/**
Programmer: Lucio Plancarte
Modified: 03 OCT 2024
Description: Driver
*/

/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following questions:
*/

//Q1: Car and Engine are related
//by which, Inheritance or Composition?
/**LLP: Composition. Car has an Engine.*/

//Q2: Color and Red are related
//by which, Inheritance or Composition?
/**LLP: Inheritance. Red is a type of Color.*/

//Q3: Shirt and Clothing are related
//by which, Inheritance or Composition?
/**LLP: Inheritance. Shirt is a type of Clothing.*/

//Q4: Furniture and Desk are related
//by which, Inheritance or Composition?
/**LLP: Inheritance. Desk is a type of Furniture.*/

//Q5: CellPhone and Battery are related
//by which, Inheritance or Composition?
/**LLP: Composition. CellPhone has a Battery.*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{

		SortedTreeSet tree = new SortedTreeSet(); //set up tree
		Person romulus = null;
		int count = 0;

		Person remus = null;
		if(args.length < 1){
			System.out.println("Missing Argument. File Name Required.");
			System.exit(1);
		}
		File inputFile = new File(args[0].toString());
		Scanner fileReader = null;
		System.out.println("Reading File: "+ inputFile);
		try{
			fileReader = new Scanner(inputFile);
			String nL = fileReader.nextLine();
			do{
				try{
					romulus = new Person(fileReader.next(),
									fileReader.nextDouble(),
									fileReader.nextDouble());
					if(romulus == null)
						break;
					//remus = new Person(romulus);
					System.out.println("Processing: "+romulus.toString());
					tree.add(romulus);
					count++;
					System.out.println("Count: "+count);

				}catch(Exception e){};
			}while(fileReader.hasNextLine());

		}catch(Exception e){ System.out.println(e.getMessage());}

		System.out.println("\nAlphabetical Order:");
		String treeOutput = tree.toString(); //call once;

		System.out.println(treeOutput);
		//System.out.println(pos.toString());
		//System.out.println("Imperial Conversion:");
		//System.out.println(pis.toString());

		System.out.println("Saving Files to Disk");
		writeToFile("hr_ordered_set_output.txt", treeOutput);
		System.out.println("hr_ordered_set_output.txt SAVED.");
		//writeToFile("hr_imperial_set_output.txt",pis);
		//System.out.println("hr_ordered_set_output.txt SAVED.");
		//System.out.println("TESTING");
		//System.out.println(ps.toString());
		//System.out.println(tree.toString());
		/*
		{
			FileWriter fileWriterOrder = new FileWriter("outputfile.txt");
			fileWriterOrder.write("testing");
			fileWriterOrder.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}*/
	}

	/**
	Writes data to output file. using SortedTreeSet toString()
	@param String outPutFileName - name of the file to use to save to disk
	@param String treeOutput - output of tree in order
	@returns VOID
	*/
	public static void writeToFile(String outPutFileName, String treeOutput){
		try{
			FileWriter fileWriterOrder = new FileWriter(outPutFileName);
			fileWriterOrder.write(treeOutput);
			fileWriterOrder.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}
	}
}

