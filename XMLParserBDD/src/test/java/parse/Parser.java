package parse;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {

	public void parse(String inputTag) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		//Build Document
		Document document = builder.parse(new File("C:\\Users\\T3j45\\eclipse-workspace\\XMLParserBDD\\src\\test\\resources\\Sample.xml"));

		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();

		//Here comes the root node
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());

		//Get all employees
		NodeList nList = document.getElementsByTagName("book");
		System.out.println("============================");

		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			Node node = nList.item(temp);
			System.out.println("");    //Just a separator
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				//Print each employee's detail
				Element eElement = (Element) node;
				System.out.println("Book id : "    + eElement.getAttribute("id"));
				System.out.println(inputTag+" tag value is : "  + eElement.getElementsByTagName(inputTag).item(0).getTextContent());
			}
		}
	}

}
