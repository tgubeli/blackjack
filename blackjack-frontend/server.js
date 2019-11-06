var express = require("express");
var app = express();
var targetBaseUrl = 'blackjack.html';

function handleRedirect(req, res) {
    const targetUrl = targetBaseUrl;
    res.redirect(targetUrl);
}

app.use(express.static('public'));

app.use('/css', express.static(__dirname + '/public/css'));
app.use('/js', express.static(__dirname + '/public/js'));
app.use('/images', express.static(__dirname + '/public/images'));

app.get('*', handleRedirect);

var server = app.listen(8080, function(){
    var port = server.address().port;
    console.log("Server started at http://localhost:%s", port);
});

