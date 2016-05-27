//用户pin\登录状态cb为方法参数，baseUrl为值参数
var checkUserLoginState = function(cb,baseUrl) {
    if (typeof cb !== 'function' ) { return;}
    $.ajax({
        type:"post",
        url:baseUrl + "/isLogin.htm",
        contentType:"application/json;charset=utf-8",
        success:function(data) {
            if (data.Identity) {
                cb(data.Identity);
            }
        },
        error:function(data){
            alert(1);
        }
    });
};

var doLogin = function(baseUrl, afterFuntion) {
    checkUserLoginState(function(r) {
        if (!r.IsAuthenticated) {
           alert('请登录');
        } else {
            afterFuntion();
        }
    },baseUrl);
};
// 添加Cookie
function addCookie(name, value, options) {
    if (arguments.length > 1 && name != null) {
        if (options == null) {
            options = {};
        }
        if (value == null) {
            options.expires = -1;
        }
        if (typeof options.expires == "number") {
            var time = options.expires;
            var expires = options.expires = new Date();
            expires.setTime(expires.getTime() + time * 1000);
        }
        document.cookie = encodeURIComponent(String(name)) + "=" + encodeURIComponent(String(value)) + (options.expires ? "; expires=" + options.expires.toUTCString() : "") + (options.path ? "; path=" + options.path : "") + (options.domain ? "; domain=" + options.domain : ""), (options.secure ? "; secure" : "");
    }
}

// 获取Cookie
function getCookie(name) {
    if (name != null) {
        var value = new RegExp("(?:^|; )" + encodeURIComponent(String(name)) + "=([^;]*)").exec(document.cookie);
        return value ? decodeURIComponent(value[1]) : null;
    }
}

// 移除Cookie
function removeCookie(name, options) {
    addCookie(name, null, options);
}