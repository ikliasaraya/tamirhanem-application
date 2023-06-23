package helper;

import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class ComponentEffect {

	public void imageViewPopup(ImageView imageView, double value) {
		imageView.setFitHeight(imageView.getFitHeight() + value);
		imageView.setFitWidth(imageView.getFitWidth() + value);
	}
	
	public void imageViewClearPopup(ImageView imageView, double value) {
		imageView.setFitHeight(value);
		imageView.setFitWidth(value);
	}
	

	public void buttonBrightnessEffect(Button button, double value) {
		ColorAdjust colorAdjust = new ColorAdjust();
		colorAdjust.setBrightness(value);
		button.setEffect(colorAdjust);
	}
	
	public void removeButtonBrightnessEffect(Button button) {
		ColorAdjust colorAdjust = null;
		button.setEffect(colorAdjust);
	}
	
	public void buttonShadowEffect(Button button, double radius, double offsetX, double offsetY, Color color) {
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(radius);
		dropShadow.setOffsetX(offsetX);
		dropShadow.setOffsetY(offsetY);
		dropShadow.setColor(color);
		button.setEffect(dropShadow);
	}
	

	
	public void removeButtonShadowEffect(Button button) {
		DropShadow dropShadow = null;
		button.setEffect(dropShadow);
	}

}
