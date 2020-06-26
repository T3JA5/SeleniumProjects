package steps;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import parse.Parser;

public class Steps extends Parser {

	public Document doc;
	public NodeList bookList;

	@Given("Read the XML file")
	public void read_the_XML_file() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.parse("C:\\Users\\T3j45\\eclipse-workspace\\XMLParserBDD\\src\\test\\resources\\Sample.xml");

	}

	@Then("Fetch the value based on inputed node")
	public void fetch_the_value_based_on_inputed_node() throws Exception {
	
		// Select from the below choice
		
		parse("author");
		//parse("title");
		//parse("price");
		//parse("genre");
		//parse("publish_date");
		//parse("description");
	}

	@Then("Fetch number of parent node")
	public void fetch_number_of_parent_node() {

		// Fetch the number of parent tag
		bookList = doc.getElementsByTagName("book");
		System.out.println("Number of parent Node present in XML are : "+bookList.getLength());
	}

	@Then("Fetch number of child node and there values")
	public void fetch_number_of_child_node_and_there_values() {
		
		// Fetch the whole xml
		bookList = doc.getElementsByTagName("book");
		int childrenCount = doc.getChildNodes().item(0).getChildNodes().getLength();
		int childs = childrenCount + 1;
		System.out.println("Number of child nodes are : "+childs);
		for(int i=0;i<bookList.getLength();i++) {
			Node b = bookList.item(i);
			if(b.getNodeType() == Node.ELEMENT_NODE) {
				Element book = (Element) b;
				String id = book.getAttribute("id");
				NodeList list = book.getChildNodes();
				for(int j=0;j<list.getLength();j++) {
					Node l = list.item(j);
					if(l.getNodeType() == Node.ELEMENT_NODE) {
						Element e = (Element) l;
						System.out.println("Book "+ id + ":" +e.getTagName()+" = "+e.getTextContent());
					}
				}
			}

		}
	}
}
