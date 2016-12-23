package slogo_turtle_ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Christopher Lu
 * Creates a TerrainImage object so that imageview's image url's can be passed into imageGallery and gridToolbar.
 */

public class TurtImage extends ImageView {
	
	private String imagePath;
	private Image image;
	private ImageGallery imgGal;
	
	public TurtImage(String imgPath, ImageGallery gal) {
		this.imagePath = imgPath;
		this.imgGal= gal;
		this.image = new Image(imgPath);
		this.setImage(image);
		clickHandler();
	}

	private void clickHandler() {
		this.setOnMouseClicked(click -> {
			imgGal.setSelectedImagePath(imagePath);
		});
	}
	
	public String getImagePath(){
		return imagePath;
	}
	
}
