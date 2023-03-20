/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package test;

import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Line;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(30).height(10);
		builder.element(new Line(new Point(0, 0), new Point(29, 9), '█'));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
    }
}
