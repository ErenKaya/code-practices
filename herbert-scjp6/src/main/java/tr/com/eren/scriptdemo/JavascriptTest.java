package tr.com.eren.scriptdemo;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavascriptTest {
	
	public static void main(String[] args) throws ScriptException {
		 // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        engine.eval("print('Hello, World')");
	}
/*
    $(document).ready(function () {

        var hashObj = new jsSHA("mySuperPassword", "ASCII");
        var password = hashObj.getHash("SHA-512", "HEX");
        var auth = false;
        $.jCryption.authenticate(password, "CryptoServlet?generateKeyPair=true", "CryptoServlet?handshake=true", function (AESKey) {
                auth = true;
            },
            function () {
                auth = false;
            });

        $('form').submit(function () {
            if (auth) {
                $('#encTridField').val($.jCryption.encrypt($('#tridField').val(), password));
                $('#tridField').val('');
                $('#encEgpField').val($.jCryption.encrypt($('#egpField').val(), password));
                $('#egpField').val('');
            }
        });
    });
*/
}
