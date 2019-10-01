#!/bin/bash

echo "###############################################################################"
echo "#  MAKE SURE YOU ARE LOGGED IN:                                               #"
echo "#  $ oc login http://console.your.openshift.com                               #"
echo "###############################################################################"

function usage() {
    echo
    echo "Usage:"
    echo " $0 [command] [options]"
    echo " $0 --help"
    echo
    echo "Example:"
    echo " $0 deploy --project-suffix mydemo"
    echo
    echo "COMMANDS:"
    echo "   deploy                   Set up the demo projects and deploy demo apps"
    echo "   delete                   Clean up and remove demo projects and objects"
    echo "   idle                     Make all demo services idle"
    echo "   unidle                   Make all demo services unidle"
    echo
}

while :; do
    case $1 in
        deploy)
            ARG_COMMAND=deploy
            ;;
        delete)
            ARG_COMMAND=delete
            ;;
        idle)
            ARG_COMMAND=idle
            ;;
        unidle)
            ARG_COMMAND=unidle
            ;;
        -h|--help)
            usage
            exit 0
            ;;
        --)
            shift
            break
            ;;
        -?*)
            printf 'WARN: Unknown option (ignored): %s\n' "$1" >&2
            shift
            ;;
        *) # Default case: If no more options then break out of the loop.
            break
    esac

    shift
done


################################################################################
# CONFIGURATION                                                                #
################################################################################

LOGGEDIN_USER=$(oc $ARG_OC_OPS whoami)
OPENSHIFT_USER=${ARG_USERNAME:-$LOGGEDIN_USER}
#PRJ_SUFFIX=${ARG_PROJECT_SUFFIX:-`echo $OPENSHIFT_USER | sed -e 's/[-@].*//g'`}
PRJ_SUFFIX=$(date '+%Y%m%d')
GITHUB_ACCOUNT=${GITHUB_ACCOUNT:-tgubeli}
GITHUB_REF=${GITHUB_REF:-master}

function deploy() {
  oc $ARG_OC_OPS new-project blackjack-$PRJ_SUFFIX   --display-name="BlackJack Game"

  sleep 2

  oc new-app openshift/mysql:5.7 --name='mysql' -e MYSQL_USER='blackjack' -e MYSQL_PASSWORD='r3dh4t1!' -e MYSQL_DATABASE=blackjack

  while [[ $(oc get pods -l app=mysql -o 'jsonpath={..status.conditions[?(@.type=="Ready")].status}') != "True" ]]; do echo "Waiting for Data Base POD to be ready..." && sleep 2; done

  echo "Initializing the DB..."

  # PATCH MYSQL DC IN ORDER TO INIT THE DB (CREATE TABLE AND DATA)
  DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
  echo ">> Actual directorio: $DIR"

  export escapedQuery=$(sed -e 's:":\\\\":g' $DIR/init_db.sql)
  eval $(sed -e "s/\$MYQUERY/$escapedQuery/" $DIR/patch_dc_db.txt)

  oc rollout latest mysql

  while [[ $(oc get pods -l app=mysql -o 'jsonpath={..status.conditions[?(@.type=="Ready")].status}') != "True" ]]; do echo "Waiting for Data Base to be ready..." && sleep 2; done

  echo "DB Ready!"

  sleep 10

  #deploy web app

}

function make_idle() {
  echo_header "Idling Services"
  oc $ARG_OC_OPS idle -n blackjack-$PRJ_SUFFIX --all
}

function make_unidle() {
  echo_header "Unidling Services"
  local _DIGIT_REGEX="^[[:digit:]]*$"

  for project in blackjack-$PRJ_SUFFIX
  do
    for dc in $(oc $ARG_OC_OPS get dc -n $project -o=custom-columns=:.metadata.name); do
      local replicas=$(oc $ARG_OC_OPS get dc $dc --template='{{ index .metadata.annotations "idling.alpha.openshift.io/previous-scale"}}' -n $project 2>/dev/null)
      if [[ $replicas =~ $_DIGIT_REGEX ]]; then
        oc $ARG_OC_OPS scale --replicas=$replicas dc $dc -n $project
      fi
    done
  done
}

function set_default_project() {
  if [ $LOGGEDIN_USER == 'system:admin' ] ; then
    oc $ARG_OC_OPS project default >/dev/null
  fi
}

function remove_storage_claim() {
  local _DC=$1
  local _VOLUME_NAME=$2
  local _CLAIM_NAME=$3
  local _PROJECT=$4
  oc $ARG_OC_OPS volumes dc/$_DC --name=$_VOLUME_NAME --add -t emptyDir --overwrite -n $_PROJECT
  oc $ARG_OC_OPS delete pvc $_CLAIM_NAME -n $_PROJECT >/dev/null 2>&1
}

function echo_header() {
  echo
  echo "########################################################################"
  echo $1
  echo "########################################################################"
}

################################################################################
# MAIN: DEPLOY DEMO                                                            #
################################################################################

if [ "$LOGGEDIN_USER" == 'system:admin' ] && [ -z "$ARG_USERNAME" ] ; then
  # for verify and delete, --project-suffix is enough
  if [ "$ARG_COMMAND" == "delete" ] || [ "$ARG_COMMAND" == "verify" ] && [ -z "$ARG_PROJECT_SUFFIX" ]; then
    echo "--user or --project-suffix must be provided when running $ARG_COMMAND as 'system:admin'"
    exit 255
  # deploy command
  elif [ "$ARG_COMMAND" != "delete" ] && [ "$ARG_COMMAND" != "verify" ] ; then
    echo "--user must be provided when running $ARG_COMMAND as 'system:admin'"
    exit 255
  fi
fi

pushd ~ >/dev/null
START=`date +%s`

echo_header "OpenShift Open Banking at Scale Demo ($(date))"

case "$ARG_COMMAND" in
    delete)
        echo "Delete demo..."
        oc $ARG_OC_OPS delete project dev-$PRJ_SUFFIX stage-$PRJ_SUFFIX cicd-$PRJ_SUFFIX
        echo
        echo "Delete completed successfully!"
        ;;
      
    idle)
        echo "Idling demo..."
        make_idle
        echo
        echo "Idling completed successfully!"
        ;;

    unidle)
        echo "Unidling demo..."
        make_unidle
        echo
        echo "Unidling completed successfully!"
        ;;

    deploy)
        echo "Deploying demo..."
        deploy
        echo
        echo "Provisioning completed successfully!"
        ;;
        
    *)
        echo "Invalid command specified: '$ARG_COMMAND'"
        usage
        ;;
esac

set_default_project
popd >/dev/null

END=`date +%s`
echo "(Completed in $(( ($END - $START)/60 )) min $(( ($END - $START)%60 )) sec)"