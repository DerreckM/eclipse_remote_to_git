import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Name     : Derreck Mansheim
 * Depaul#  : 4457125
 * Class    : SE 450
 * Homework : #2
 * Problem  : LectureTwo
 * Due Date : 09/26/2016
 *
 * class LectureTwo
 *
 */

public class ShapeParser
{
	public static ArrayList<Shape> loadShapes(final String shapeFile)
	{
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        
		try
		{ 
	        JSONParser parser = new JSONParser();
	 
	        Object obj = parser.parse(new FileReader("shapes.json"));
	 
	        JSONObject jsonObject = (JSONObject) obj;
	 
	        JSONArray jsonArray = (JSONArray) jsonObject.get("shapes");
	        
	        Iterator<?> jsonIterator = jsonArray.iterator();
	        while (jsonIterator.hasNext())
	        {
	        	JSONObject someShape = (JSONObject)jsonIterator.next();
	        	if (someShape.containsKey("type"))
	        	{
	            	Object value = someShape.get("type");
	            	if (value.equals("Circle"))
	            	{
	            		Circle circle = new Circle(extract(someShape.get("left")),
	    	            						   extract(someShape.get("top")),
	    	    	            				   extract(someShape.get("right")),
	    	    	    	            		   extract(someShape.get("bottom")),
	    	    	    	            		   extract(someShape.get("x")),
	    	    	    	            		   extract(someShape.get("y")),
	    	    	    	            		   extract(someShape.get("rotation")),
	    	    	    	            		   extract(someShape.get("color")));
	            		shapes.add(circle);
	            	}
	            	else if (value.equals("Square"))
	            	{
	            		Square square = new Square(extract(someShape.get("left")),
	    	            						   extract(someShape.get("top")),
	    	    	            				   extract(someShape.get("right")),
	    	    	    	            		   extract(someShape.get("bottom")),
	    	    	    	            		   extract(someShape.get("x")),
	    	    	    	            		   extract(someShape.get("y")),
	    	    	    	            		   extract(someShape.get("rotation")),
	    	    	    	            		   extract(someShape.get("color")));
	            		shapes.add(square);
	            	}
	            	else if (value.equals("Line"))
	            	{
	            		Line line = new Line(extract(someShape.get("left")),
	    	            				     extract(someShape.get("top")),
	    	    	            		     extract(someShape.get("right")),
	    	    	    	                 extract(someShape.get("bottom")),
	    	    	    	                 extract(someShape.get("x")),
  	    	    	            		     extract(someShape.get("y")),
  	    	    	            		     extract(someShape.get("rotation")),
  	    	    	            		     extract(someShape.get("color")));
	            		shapes.add(line);
	            	}
	            	else if (value.equals("Triangle"))
	            	{
	            		Triangle triangle = new Triangle(extract(someShape.get("left")),
	    	            				     extract(someShape.get("top")),
	    	    	            		     extract(someShape.get("right")),
	    	    	    	                 extract(someShape.get("bottom")),
	    	    	    	                 extract(someShape.get("x")),
  	    	    	            		     extract(someShape.get("y")),
  	    	    	            		     extract(someShape.get("rotation")),
  	    	    	            		     extract(someShape.get("color")));
	            		shapes.add(triangle);
	            	}
	            	/*else if (value.equals("Diamond"))
	            	{
	            		Diamond diamond = new Diamond(extract(someShape.get("left")),
	    	            				     extract(someShape.get("top")),
	    	    	            		     extract(someShape.get("right")),
	    	    	    	                 extract(someShape.get("bottom")),
	    	    	    	                 extract(someShape.get("x")),
  	    	    	            		     extract(someShape.get("y")),
  	    	    	            		     extract(someShape.get("rotation")),
  	    	    	            		     extract(someShape.get("color")));
	            		shapes.add(diamond);
	            	}*/
	            	else
	            	{
	            		//throw new BadShapeException();
	            		//use your exception class and maybe throw exception about bad data?
	            	}
	        	}
	        }
		}
        catch(FileNotFoundException eFileNotFound)
        {
        }
        catch(IOException eIOException)
        {
        	
        }
        catch(ParseException eParseException)
        {
        	
        }
		
		return shapes;
	}

  	private final static Float extract(final Object object)
  	{
  		return Float.parseFloat(object.toString());
  	} 	
  	
}
      