package org.graphstream.ui.javafx.renderer.shape.javafx.baseShapes;

import org.graphstream.ui.graphicGraph.GraphicElement;
import org.graphstream.ui.javafx.Backend;
import org.graphstream.ui.view.camera.DefaultCamera2D;
import org.graphstream.ui.javafx.renderer.Skeleton;
import org.graphstream.ui.javafx.renderer.shape.javafx.baseShapes.Form.Rectangle2D;

public abstract class RectangularAreaShape extends AreaShape {
	private Rectangle2D theShape = new Rectangle2D();
	
	@Override
	public void make(Backend backend, DefaultCamera2D camera) {
		double w = area.theSize.x;
		double h = area.theSize.y;
		
		((Form)theShape()).setFrame(area.theCenter.x-w/2, area.theCenter.y-h/2, w, h);	
	}

	@Override
	public void makeShadow(Backend backend, DefaultCamera2D camera) {
		double x = area.theCenter.x + shadowable.theShadowOff.x;
		double y = area.theCenter.y + shadowable.theShadowOff.y;
		double w = area.theSize.x + shadowable.theShadowWidth.x * 2;
		double h = area.theSize.y + shadowable.theShadowWidth.y * 2;
		
		((Form)theShape()).setFrame(x-w/2, y-h/2, w, h);
	}

	@Override
	public void render(Backend bck, DefaultCamera2D camera, GraphicElement element, Skeleton skel) {
		make(bck, camera);
 		fillable.fill(bck.graphics2D(), theShape(), camera);
 		strokable.stroke(bck.graphics2D(), theShape());
 		decorArea(bck, camera, skel.iconAndText, element, theShape());
	}

	@Override
	public void renderShadow(Backend bck, DefaultCamera2D camera, GraphicElement element, Skeleton skeleton) {
		makeShadow(bck, camera);
 		shadowable.cast(bck.graphics2D(), theShape());
	}
	
	public Form theShape() {
		return theShape;
	}
}