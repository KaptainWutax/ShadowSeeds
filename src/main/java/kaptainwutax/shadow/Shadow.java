package kaptainwutax.shadow;

import kaptainwutax.seedutils.mc.seed.WorldSeed;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Shadow {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setSize(800, 400);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JTextField textField = new JTextField();
		textField.setBounds(800 / 2 - 300 / 2,400 / 2 -  40 / 2 - 50, 300, 30);

		JButton button = new JButton("Shadow");
		button.setBounds(800 / 2 - 100 / 2,400 / 2 -  40 / 2, 100, 30);
		button.setEnabled(false);

		textField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					Long.parseLong((textField.getText() + e.getKeyChar()).trim());
					button.setEnabled(true);
				} catch(Exception _e) {
					button.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		button.addActionListener(event -> {
			try {
				long seed = Long.parseLong(textField.getText().trim());
				textField.setText(String.valueOf(WorldSeed.getShadowSeed(seed)));
			} catch(NumberFormatException e) {

			}
		});

		frame.add(textField);
		frame.add(button);

		frame.setLayout(null);
		frame.setVisible(true);
	}

	/*
	@Override
	public void start(Stage stage) {
		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 800, 450);
		stage.setScene(scene);
		stage.show();

		TextField textField = new TextField();
		textField.setMaxWidth(400.0D);
		textField.setTranslateY(-40.0D);

		Button button = new Button();
		button.setText("Shadow");
		button.setDisable(true);

		textField.setOnKeyTyped(event -> {
			try {
				Long.parseLong(textField.getText().trim() + event.getCharacter().trim());
				button.setDisable(false);
			} catch(Exception e) {
				button.setDisable(true);
			}
		});

		button.setOnMouseClicked(event -> {
			try {
				long seed = Long.parseLong(textField.getText().trim());
				textField.setText(String.valueOf(WorldSeed.getShadowSeed(seed)));
			} catch(NumberFormatException e) {

			}
		});

		pane.getChildren().addAll(textField, button);
	}*/

}
