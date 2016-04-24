package inclassGraphs;


import inClassGivenItems.AbstractGraph;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayUSMap extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		City[] vertices = {
				new City("Seattle", 75, 50),        //0
				new City("San Francisco", 50, 210), //1
				new City("Los Angeles", 75, 275),   //2
				new City("Denver", 275, 175),       //3
				new City("Kansas City", 400, 245),  //4
				new City("Chicago", 450, 100),      //5
				new City("Boston", 700, 80),        //6
				new City("New York", 650, 120),     //7
				new City("Atlanta", 575, 295),      //8
				new City("Miami", 600, 400),        //9
				new City("Dallas", 408, 325),       //10
				new City("Houston", 450, 360),      //11 
				new City("Charlotte", 650, 300)     //12
		};

		// Edge array for graph in Figure 28.1
		int[][] edges = {
				//City based on the leading digit
				/*Seattle*/        {0, 1}, {0, 3}, {0, 5},  
				/*San Francisco */ {1, 0}, {1, 2}, {1, 3},  
				/*Los Angeles*/    {2, 1}, {2, 3}, {2, 4}, {2, 10}, 
				/*Denver*/         {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
				/*Kansas City*/    {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
				/*Chicago*/        {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
				/*Boston*/         {6, 5}, {6, 7}, 
				/*New York*/       {7, 4}, {7, 5}, {7, 6}, {7, 8},
				/*Atlanta*/        {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11}, {8, 12},
				/*Miami*/          {9, 8}, {9, 11}, {9,12},
				/*Dallas*/         {10, 2}, {10, 4}, {10, 8}, {10, 11},
				/*Houston*/        {11, 8}, {11, 9}, {11, 10}, {11,12},
				/*Charlotte*/      {12, 8}, {12,9}, {12,11}
		};
		
		//created pane
		GridPane gp = new GridPane();
		
		//created graph from the above arrays
		Graph<City> graph = new UnweightedGraph<>(vertices, edges);
		gp.add(new GraphView(graph), 0, 0, 1, 1);
		
		//created a button 
		Button buttonBFS = new Button("BFS");
		buttonBFS.setOnAction(e -> {
			displayBFS(graph, 0);
		});
		gp.add(buttonBFS, 0, 2,1,2);
		
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(gp, 750, 450);
		primaryStage.setTitle("DisplayUSMap"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public void displayBFS(Graph<City> graph, int n)
	{

		inclassGraphs.AbstractGraph<City>.Tree bfs = 
				graph.bfs(n); 
		java.util.List<Integer> searchOrders = bfs.getSearchOrder();
		System.out.println(bfs.getNumberOfVerticesFound() +
				" vertices are searched in this order:");
		for (int i = 0; i < searchOrders.size(); i++)
			System.out.println(graph.getVertex(searchOrders.get(i)));

		for (int i = 0; i < searchOrders.size(); i++)
			if (bfs.getParent(i) != -1)
				System.out.println("parent of " + graph.getVertex(i) + 
						" is " + graph.getVertex(bfs.getParent(i)));
	}

	static class City implements Displayable {
		private int x, y;
		private String name;

		City(String name, int x, int y) {
			this.name = name;
			this.x = x;
			this.y = y;
		}

		@Override 
		public int getX() {
			return x;
		}

		@Override 
		public int getY() {
			return y;
		}

		@Override 
		public String getName() {
			return name;
		}
		@Override 
		public String toString() {
			return name;
		}
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
