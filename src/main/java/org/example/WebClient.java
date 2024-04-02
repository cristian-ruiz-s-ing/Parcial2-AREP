package org.example;

public class WebClient {
    public static String getClient() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Form Example</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>MathServices</h1>\n" +
                "<form action=\"/mathservices\">\n" +
                "    <label for=\"fun\">Función:</label><br>\n" +
                "    <input type=\"text\" id=\"fun\" name=\"function\" value=\"factors\"><br><br>\n" +
                "    <label for=\"value\">Valor:</label><br>\n" +
                "    <input type=\"number\" id=\"value\" name=\"value\" value=\"15\"><br><br>\n" +
                "    <input type=\"button\" value=\"Submit\" onclick=\"loadGetResp()\">\n" +
                "</form>\n" +
                "<div id=\"getResp\"></div>\n" +
                "\n" +
                "<script>\n" +
                "    function loadGetResp() {\n" +
                "        let fun = document.getElementById(\"fun\").value;\n" +
                "        let val = document.getElementById(\"value\").value;\n" +
                "        const xhttp = new XMLHttpRequest();\n" +
                "        xhttp.onload = function() {\n" +
                "            document.getElementById(\"getResp\").innerHTML =\n" +
                "            this.responseText;\n" +
                "        }\n" +
                "        xhttp.open(\"GET\", \"/mathservice/\"+fun+\"/\"+val);\n" +
                "        xhttp.send();\n" +
                "    }\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";
    }
}
