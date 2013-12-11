import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.namespace.QName;
public class SimpleSOAP extends HttpServlet{
    private static final String endpoint = "http://wbd032.ap01.aws.af.cm/SimpleSOAP.php";
	public void DoSOAP() throws SOAPException{
		SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();
 
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setAttribute("namespace","namespaceUrl");
 
        SOAPBody body = message.getSOAPBody();
        QName bodyName = new QName("getHello");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
        SOAPElement symbol = bodyElement.addChildElement("name");
        symbol.addTextNode("Harry Joy");
 
        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();
 
        SOAPBody responseBody = response.getSOAPBody();
        SOAPBodyElement responseElement = (SOAPBodyElement)responseBody.getChildElements().next();
        SOAPElement returnElement = (SOAPElement)responseElement.getChildElements().next();
        if(responseBody.getFault()!=null){
            System.out.println(returnElement.getValue()+" "+responseBody.getFault().getFaultString());
        } else {
            System.out.println(returnElement.getValue());
        }
 
        try {
            System.out.println(getXmlFromSOAPMessage(message));
            System.out.println(getXmlFromSOAPMessage(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void doGet(HttpServletRequest request, HttpServletResponse Response) throws ServletException,IOException
	{	
		Response.getWriter().println("SOAPING");
		try{
			DoSOAP();}
		catch (SOAPException S){};
		Response.getWriter().println("SELESAI SOAPING");
    }
 
    private static String getXmlFromSOAPMessage(SOAPMessage msg) throws SOAPException, IOException {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        msg.writeTo(byteArrayOS);
        return new String(byteArrayOS.toByteArray());
    }
 
}