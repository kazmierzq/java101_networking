package org.example;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

class HtmlUnitExample {
    public static void main(String[] args) throws Exception {

        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setUseInsecureSSL(true);

        HtmlPage page = webClient.getPage("https://mvnrepository.com/");

        System.out.println("Page title: " + page.getTitleText());
        System.out.println("Page XML: " + page.asXml().substring(0,100));
        System.out.println("Page text: " + page.asNormalizedText().substring(0,100));

        HtmlElement body = (HtmlElement) page.getElementById("page");
        System.out.println(body.asNormalizedText().substring(0,50));

        System.out.println("num inputs: " + page.getElementsByTagName("input").size());

        HtmlForm form = page.getForms().get(0);
        HtmlSubmitInput submit = form.getOneHtmlElementByAttribute("input", "type", "submit");
        HtmlTextInput input = (HtmlTextInput) page.getHtmlElementById("query");
        input.setValueAttribute("htmlunit");

        HtmlPage results = submit.click();
        System.out.println("Results page title: " + results.getTitleText());
        DomNodeList<DomNode> data = results.querySelectorAll(".im-header");
        System.out.println("Number of query results: " + data.size());

        System.out.println(data.get(0).asNormalizedText());
    }
}
