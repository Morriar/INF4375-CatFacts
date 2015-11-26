function loadFact(id) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', encodeURI('/facts/fragment'));
    xhr.onload = function() {
        if (xhr.status === 200) {
            var html = xhr.responseText;
            console.log(html);

            var div = document.getElementById("facts");
            div.innerHTML = html;
        }
        else {
            console.log("Request Failed: " + xhr.status);
        }
    };
    xhr.send();
}