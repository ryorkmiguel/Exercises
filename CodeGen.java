/**
 * 
 */
package com.srccodes.examples;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author yorkmiguel
 *
 */
public class CodeGen {

	/**
	 * @param args
	 */
	
	Document doc;
	Node root;
	String generatedCode;
	String inFileName;
	String outFileName;
	
	
	public static void main(String[] args) {
		CodeGen cg = new CodeGen("/Users/yorkmiguel/Documents/Java Full Stack/Bootstrap Code Generator java/codegen.xml");
		cg.generate();
		System.out.println(cg.getGeneratedCode());

	}
	
	/**
	 * @param generatedCode
	 * @param inFileName
	 * @param outFileName
	 */
	public CodeGen(String inFileName) {
		this.generatedCode = "";
		this.inFileName = inFileName;
		this.outFileName = "";
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//DocumentBuilderFactory dbf = new DocumentBuilderFactory();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(inFileName);
			root = doc.getDocumentElement();
		} catch (Exception e) {e.printStackTrace();}
	}

	public void generate() {
		generateHead();
		generateNav();
		generateGrid();
		generatedCode+="\t</body>\n</html>";
		
	}
	
	public void generateHead() {
		String title = "";
		generatedCode="<!DOCTYPE html>\n<html>\n\t<head>\n\t";
		NodeList items = doc.getElementsByTagName("htmlpage"); // there should be only one
		Node item = (Node)items.item(0);
		if(item.getNodeType() == Node.ELEMENT_NODE) {
			Element headElement = (Element)item;
			outFileName = headElement.getAttribute("name");
			title = headElement.getAttribute("title");
		}
		generatedCode+="<title>"+title+"</title>\n";
		generatedCode+="<meta charset=\"utf-8\">\n";
		generatedCode+="<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
		generatedCode+="<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\n";
		generatedCode+="<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n";
		generatedCode+="<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n";
		generatedCode+="<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n";
		generatedCode+="</head>\n";
		generatedCode+="<body>\n";
	}
	
	public void generateNav() {
		String navItem;
		String target;
		String navDD;
		boolean hasMenu = false;
		NodeList items = doc.getElementsByTagName("menubar"); // there should be zero or one
		if(items.getLength()>0) { // found menubar. Generate top level code
			hasMenu = true;
			generatedCode+="	<nav class=\"navbar navbar-expand-lg navbar-light bg-light sticky-top\" >\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">Navbar</a>\r\n" + 
					"		<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
					"			<span class=\"navbar-toggler-icon\"></span>\r\n" + 
					"		</button>\r\n" + 
					"\n";
			generatedCode+="		<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n" + 
					"			<ul class=\"navbar-nav mr-auto\">\r\n" + 
					"";			Node item = (Node)items.item(0);
			if (item.hasChildNodes()) { // it should. menubar by itself has nothing
				NodeList menuItems = ((Element)item).getElementsByTagName("menuitem");
				for (int i=0; i<menuItems.getLength();i++) {
					Node nodeItem = menuItems.item(i);
					if(nodeItem.getNodeType() == Node.ELEMENT_NODE) {
						Element leafElement = (Element)item;
						navItem = leafElement.getAttribute("name");
						target = leafElement.getAttribute("target");
						generatedCode+="				<li class=\"nav-item active\">\r\n" + 
								"					<a class=\"nav-link\" href=\""+target+"\">"+navItem+"<span class=\"sr-only\">(current)</span></a>\r\n" + 
								"				</li>\r\n" + 
								"";
					}
				}
			}
			generatedCode+="			</ul>\r\n" + 
					"		</div>\r\n" + 
					"	</nav>\r\n" + 
					"";
		}
	}
	
	public void generateGrid() {
		
	}

	/**
	 * @return the inFileName
	 */
	public String getInFileName() {
		return inFileName;
	}


	/**
	 * @param inFileName the inFileName to set
	 */
	public void setInFileName(String inFileName) {
		this.inFileName = inFileName;
	}


	/**
	 * @return the outFileName
	 */
	public String getOutFileName() {
		return outFileName;
	}


	/**
	 * @param outFileName the outFileName to set
	 */
	public void setOutFileName(String outFileName) {
		this.outFileName = outFileName;
	}


	/**
	 * @return the generatedCode
	 */
	public String getGeneratedCode() {
		return generatedCode;
	}

}
