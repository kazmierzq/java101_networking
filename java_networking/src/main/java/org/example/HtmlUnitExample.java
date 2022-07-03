package org.example;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

public class HtmlUnitExample {
    public static void main(String[] args) throws Exception{

        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setUseInsecureSSL(true);

        HtmlPage page = webClient.getPage("https://mvnrepository.com/");

        System.out.println("page title: " + page.getTitleText());
        System.out.println("Page XML: " + page.asXml().substring(0, 50));
        System.out.println("Page text: " + page.asText().substring(0,50));

        HtmlElement body = (HtmlElement) page.getElementById("page");
        System.out.println( body.asText().substring(0,50) );

        System.out.println("num inputs: " + page.getElementsByTagName("input").size() );

        HtmlForm form = page.getForms().get(0);
        HtmlSubmitInput submit = form.getOneHtmlElementByAttribute("input", "type", "submit");
        HtmlTextInput input = (HtmlTextInput) page.getElementById("query");
        input.setValueAttribute("htmlunit");

        HtmlPage results = submit.click();
        System.out.println("Results text title: " +  results.getTitleText());
        DomNodeList<DomNode> data = results.querySelectorAll(".im-header");
        System.out.println("Number of query results: " + data.size());

        System.out.println(data.get(0).asText());

    }
}
