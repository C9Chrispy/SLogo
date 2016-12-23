package slogo_turtle_ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Christopher Lu
 * ImageGallery displays images in a grid based view by iterating through files and
 * placing imageviews of the files in a horizontal tile pane.
 */

public class ImageGallery {
	
	private Stage galleryStage;
	private Scene scene;
	private String filePath;
	private String selectedImagePath;
	private ScrollPane scrollPane;
	private ListView<TurtImage> imagePane;
	private int screenWidth;
	private VBox container;
	private Button confirmImage;
	private ResourceBundle myResources;
	private String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private ImageView turtleImageView;
	private TurtleSprite turtleSprite;
	
	public ImageGallery(TurtleSprite s, ImageView turtleView, String fPath) {
		setUpScreenResolution();
		this.myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "View");
		this.scrollPane = new ScrollPane();
		this.galleryStage = new Stage();
		this.container = new VBox();
		this.turtleImageView = turtleView;
		this.turtleSprite = s;
		container.setId("vbox");
		imagePane = new ListView<TurtImage>();
		imagePane.setOrientation(Orientation.HORIZONTAL);
		imagePane.setId("background");
		imagePane.setMaxHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4);
		imagePane.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);
		this.filePath = fPath;
		this.confirmImage = new Button(myResources.getString("ApplyChanges"));
		confirmImage.setId("button");
		container.getChildren().addAll(imagePane, confirmImage);
		this.scene = new Scene(container);
		populatePane();
		galleryStage.setScene(scene);
		galleryStage.show();
		confirmImageHandler();
	}
	
	private void setUpScreenResolution() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = (int) screenSize.getWidth();
	}
	
	private void populatePane() {
		String path = myResources.getString("TerrainImageFilePath").substring(1);
		File file = new File(path);
		File[] fileList = file.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			TurtImage image  = new TurtImage(fileList[i].toURI().toString(), this);
			image.setFitWidth(screenWidth*0.1);
			image.setFitHeight(screenWidth*0.1);
			imagePane.getItems().add(image);
		}
	}
	
	private void confirmImageHandler() {
		confirmImage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					selectedImagePath = imagePane.getSelectionModel().getSelectedItem().getImagePath();
					String[] pathArray = selectedImagePath.split("/");
					String relPath = "";
					for (int i = pathArray.length-3; i < pathArray.length; i++) {
						relPath += pathArray[i] + "/";
					}
					turtleSprite.setImage(relPath);
					Image turtleImage = new Image(relPath);
					turtleImageView = new ImageView(turtleImage);
					turtleSprite.setTurtleImageView(turtleImageView);
					galleryStage.close();
				} catch (Exception e1) {
					galleryStage.close();
				}
			}
		});
	}
	
	public void setSelectedImagePath(String newPath) {
		selectedImagePath = newPath;
	}
	
	public String getSelectedImagePath() {
		return selectedImagePath;
	}
	
}
