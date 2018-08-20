function Cc(names, ids) {
    console.log(1);
    console.log(names);
    console.log(ids);
    var num = new Number(1.11);
    console.log(Number.MAX_VALUE);
    console.log(navigator.javaEnabled());
    console.log(window.screen.availWidth + "-------");
    var aa = new Array("11", "22");
    console.log(aa.toString());
}

Cc.prototype.Dd=function gg() {
    console.log(3);
}

function Fa() {
    function Son() {
        Son.height.constructor.call(this);
        console.log("ada");
    }
}

function open() {
    Window.open("www.baidu.com");
}

function close() {
    Window.close();
}

/**
 *
 * @constructor
 */
function MyStyle() {
    //获取当前的风格
    var boyDiv = $("<div></div>");
    boyDiv.attr("id", "boyDiv");
    boyDiv.addClass("boyDiv");
    var parentDiv = $("#myStyle");
    boyDiv.appendTo(parentDiv);
}


var Dd = function () {
    console.log(11);
}
