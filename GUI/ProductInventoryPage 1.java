package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import Entity.*;
import EntityList.*;
import javax.swing.filechooser.FileNameExtensionFilter;

//import File.FileIO;

public class ProductInventoryPage extends JFrame implements ActionListener{
	Font titleFont = new Font("cambria",Font.BOLD,30);
	Font font15 = new Font("cambria",Font.BOLD,15);
	Font font20 = new Font("cambria",Font.BOLD,20);
	
	JTextField codeTextField,nameTextField,quantityTextField,priceTextField,discountTextField;
	JTextField searchTextField,deleteTextField;
	JTextArea display;
	
	
	JButton addButton,updateButton,searchButton,deleteButton,clearButton,showAllButton;
	ProductList productList = new ProductList(1000);
	
	public ProductInventoryPage(){
		super("Cartio");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(940,650); //width, height
		this.setLocation(150,0); //X, Y
		this.getContentPane().setBackground(new Color(218,232,252));
		this.setLayout(null);

		//===========DEMO DATA=================
		//FileIO.loadBooksFromFile(bookList);
		
		//=================Image Example====================

	
		//============= Title ===========
		JLabel title = new JLabel("Cartio");
		title.setBounds(400,10,500,50); //X,Y,W,H
		title.setFont(titleFont);
		
		//=========== Sub Title ==========
		JLabel subTitle = new JLabel("PRODUCT INFORMATIONS");
		subTitle.setBounds(300,60,320,50); //X,Y,W,H
		subTitle.setFont(new Font("Cambria",Font.BOLD,25));
		
		
		//////////////////////////////////////////////////////////////////////////////
		//---------------------- LEFT SIDE COMPONENTS ------------------------------//
		//////////////////////////////////////////////////////////////////////////////
		
		//============ Entry Form ===========
		int top = 100;
		int gap = 40;
		//============ Code Entry  ===========
		JLabel codeLabel = new JLabel("Product ID");
		codeLabel.setBounds(20,top,200,30); //X,Y,W,H
		codeLabel.setFont(font15);
		
		codeTextField = new JTextField();
		codeTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		codeTextField.setFont(font15);
		
		//============ Name Entry  ===========
		JLabel nameLabel = new JLabel("Product Name");
		nameLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		nameLabel.setFont(font15);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		nameTextField.setFont(font15);
		
		//============Product Quantity Entry  ===========
		JLabel quantityLabel = new JLabel("Product Quantity");
		quantityLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		quantityLabel.setFont(font15);
		
		quantityTextField = new JTextField();
		quantityTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		quantityTextField.setFont(font15);
		
		//============Price Entry  ===========
		JLabel priceLabel = new JLabel("Product Price");
		priceLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		priceLabel.setFont(font15);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		priceTextField.setFont(font15);
		
		//============Discount Entry  ===========
		JLabel discountLabel = new JLabel("Discount (%)");
		discountLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		discountLabel.setFont(font15);
		
		discountTextField = new JTextField();
		discountTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		discountTextField.setFont(font15);
		
		//============Product Entry  Buttons===========
		addButton = new JButton("ADD");
		addButton.setBounds(20,top+=gap+20,200,30); //X,Y,W,H
		addButton.setBackground(Color.GREEN);
		addButton.setFont(font15);
		addButton.addActionListener(this);
		
		
		updateButton = new JButton("UPDATE");
		updateButton.setBounds(20,top+=gap,200,30); //X,Y,W,H
		updateButton.setBackground(Color.BLUE);
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(font15);
		updateButton.addActionListener(this);
		
		
		//============RIGHT SIDE COMPONENTS=========
		top = 100;
		gap = 40;
		//============Produc Search Entry  ===========
		JLabel searchLabel = new JLabel("Search By Product ID");
		searchLabel.setBounds(700,top,200,30); //X,Y,W,H
		searchLabel.setFont(font15);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(700,top+=gap,200,30); //X,Y,W,H
		searchTextField.setFont(font15);
		
		searchButton = new JButton("SEARCH");
		searchButton.setBounds(700,top+=gap,200,30); //X,Y,W,H
		searchButton.setBackground(Color.YELLOW);
		searchButton.setFont(font15);
		searchButton.addActionListener(this);
		
		
		//============Product Delete Entry  ===========
		JLabel deleteLabel = new JLabel("Delete By Product ID");
		deleteLabel.setBounds(700,top+=gap,200,30); //X,Y,W,H
		deleteLabel.setFont(font15);
		
		deleteTextField = new JTextField();
		deleteTextField.setBounds(700,top+=gap,200,30); //X,Y,W,H
		deleteTextField.setFont(font15);
		
		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(700,top+=gap,200,30); //X,Y,W,H
		deleteButton.setBackground(Color.RED);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(font15);
		deleteButton.addActionListener(this);
		
		///////////////// Show All product information ///////////////
		
		showAllButton = new JButton("SHOW ALL");
		showAllButton.setBounds(700,500,200,30); //X,Y,W,H
		showAllButton.setBackground(Color.PINK);
		showAllButton.setForeground(Color.WHITE);
		showAllButton.setFont(font15);
		showAllButton.addActionListener(this);
		
		///////////////// Clear Screen ///////////////
		
		clearButton = new JButton("CLEAR SCREEN");
		clearButton.setBounds(700,550,200,30); //X,Y,W,H
		clearButton.setBackground(Color.DARK_GRAY);
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(font15);
		clearButton.addActionListener(this);
		
		//Data Display Area
		display = new JTextArea();
		display.setFont(font20);
		JScrollPane jsp = new JScrollPane(display);
		jsp.setBounds(250,100,400,500);
		this.add(jsp);
		
		reloadData();
			
		
		
		//================= ADD ALL THE COMPONENTS TO CONTAINER ======================//
		this.add(title);
		this.add(subTitle);
		this.add(codeLabel);
		this.add(codeTextField);
		this.add(nameLabel);
		this.add(nameTextField);
		this.add(quantityLabel);
		this.add(quantityTextField);
		this.add(priceLabel);
		this.add(priceTextField);
		this.add(discountLabel);
		this.add(discountTextField);
		this.add(addButton);
		this.add(updateButton);
		this.add(searchLabel);
		this.add(searchTextField);
		this.add(searchButton);
		this.add(deleteLabel);
		this.add(deleteTextField);
		this.add(deleteButton);
		this.add(clearButton);
		this.add(showAllButton);
		
		//================= DISPLAY THE FRAME ======================//
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(addButton == e.getSource()){
			System.out.println("ADD CLICKED");
			if(productList.getByCode(codeTextField.getText())==null){
				if(!codeTextField.getText().isEmpty() && 
				!nameTextField.getText().isEmpty() && 
				!quantityTextField.getText().isEmpty() && 
				!priceTextField.getText().isEmpty() && 
				!discountTextField.getText().isEmpty() ){
					Product p = new Product(codeTextField.getText(),
										nameTextField.getText(),
										Integer.parseInt(quantityTextField.getText()),
										Integer.parseInt(priceTextField.getText()),
										Integer.parseInt( discountTextField.getText()) );
					productList.insert(p);
					//FileIO.writeBookInFile(p);
					reloadData();
				}
				else{
					JOptionPane.showMessageDialog(this,"Please Provide All Information","Missing Data",JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"Code Already Used","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		else if(updateButton == e.getSource()){
			System.out.println("UPDATE CLICKED");
			
			
			//update
			
			Product p = productList.getByCode( codeTextField.getText());
			if( p!= null){
				if(!nameTextField.getText().isEmpty()){
					p.setProductName(nameTextField.getText());
				}
				if(!quantityTextField.getText().isEmpty()){
					p.setProductQuantity(Integer.parseInt(quantityTextField.getText()));
				}
				if(!priceTextField.getText().isEmpty()){
					p.setProductPrice(Integer.parseInt(priceTextField.getText()));
				}
				if(!discountTextField.getText().isEmpty()){
					p.setDiscount( Integer.parseInt( discountTextField.getText()));
				}
				reloadData();
				JOptionPane.showMessageDialog(this,"Product Informations are Updated");
			}
			else{
				JOptionPane.showMessageDialog(this,"No product Found with this code");
			}
			
			
			
		}
		else if(searchButton == e.getSource()){
			System.out.println("SEARCH CLICKED");	
			Product p = productList.getByCode( searchTextField.getText());
			if( p != null){
				display.setText(p.toString());
			}
			else{
				JOptionPane.showMessageDialog(this,"No Product Found with this code");
			}
		}
		else if(deleteButton == e.getSource()){
			System.out.println("DELETE CLICKED");
			Product p = productList.getByCode( deleteTextField.getText());
			if(p!=null){
				productList.removeByCode(deleteTextField.getText());
				reloadData();
			}
			else{
				JOptionPane.showMessageDialog(this,"No Product Found with this Code","Error",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else if(showAllButton == e.getSource()){
			System.out.println("SHOW ALL CLICKED");
			reloadData();
		}
		else if(clearButton == e.getSource()){
			System.out.println("CLEAR CLICKED");
		}
	}
	
	public void reloadData(){
		display.setText(productList.getAllProductAsString());
	}
	
}