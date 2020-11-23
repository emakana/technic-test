package xyz.foobar.test;

import xyz.foobar.Diff;
import xyz.foobar.DiffException;
import xyz.foobar.renderer.DiffRenderer;
import xyz.foobar.renderer.DiffRendererImpl;
import xyz.foobar.service.DiffEngine;
import xyz.foobar.service.DiffService;

public class DiffUnitTest {
	
	
    public static void main(String [] args) {
    	
    	DiffEngine engine = null;
    	DiffRenderer renderer = null;
    	
    	engine = new DiffService();
		renderer = new DiffRendererImpl();
		
        Person p1 = new Person("Alfred", "Makoa", null, null, null);
        Person p2 = null;
        
        
        try {
        Diff diff = (Diff) engine.calculate(p1, p2);
        
        
        renderer.render(diff);
        } catch (DiffException e) {
        	e.printStackTrace();
        }
        
        
    }
    

}
