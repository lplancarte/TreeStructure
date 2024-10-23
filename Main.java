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

		//A
		//Person mario = new Person("Mario",187,95);

		//B
		//PersonSet ps = new PersonSet();
		//ps.add(mario);
		//Person marioTest = ps.get(0);
		//System.out.println("PersonSet.Get(index:0)= "+marioTest.toString());

		//C
		//System.out.println("\nRead data from file and Display to Screen:");
		/*
		// Don't overcomplicate the data
		// reading. After skipping the
		// first row, you can use the
		// following to read a row of
		// character info, assuming your
		// Scanner is named "fileReader"
		*/

		/**
			PART 2
			A)Instantiate a PersonOrderedSet and PersonImperialSet
			B)Read in Data, populate both sets objects with Persons
			C)Write out data into two separate output files
				1) Ordered		2)Imperial
			D)Output formatted data with header to separate files named:
				hr_imperial_set_output.txt &&	hr_ordered_set_output.txt
		*/
		//A
		PersonOrderedSet pos = new PersonOrderedSet();
		System.out.println("PersonOrderedSet Object Created.");
		PersonImperialSet pis = new PersonImperialSet();
		System.out.println("PersonImperialSet Object Created.");
		//PersonSet ps = new PersonSet(); //TESTING
		//B
		Person romulus = null;
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
				//String name = fileReader.next();
				//double height = fileReader.nextDouble();
				//double weight = fileReader.nextDouble();
				//System.out.println(name);
				//System.out.println(height);
				//System.out.println(weight);
				//System.out.println();
				try{
					romulus = new Person(fileReader.next(),
									fileReader.nextDouble(),
									fileReader.nextDouble());
					if(romulus == null)
						break;
					remus = new Person(romulus);
					//ps.add(romulus); //TESTING
					//Add to PersonOrderedSet
					pos.add(romulus);

					//assert to check the copy of romulus is remus
					boolean personObjectCopied = romulus.equals(remus);
					assert personObjectCopied;

					//Add to PersonImperialSet
					pis.add(remus);
				}catch(Exception e){};
			}while(fileReader.hasNextLine());

		}catch(Exception e){ System.out.println(e.getMessage());}

		System.out.println("Alphabetical Order:");
		System.out.println(pos.toString());
		System.out.println("Imperial Conversion:");
		System.out.println(pis.toString());
		
		System.out.println("Saving Files to Disk");
		writeToFile("hr_ordered_set_output.txt",pos);
		System.out.println("hr_ordered_set_output.txt SAVED.");
		writeToFile("hr_imperial_set_output.txt",pis);
		System.out.println("hr_ordered_set_output.txt SAVED.");
		//System.out.println("TESTING");
		//System.out.println(ps.toString());
		
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
	Writes data to output file. Uses the superclass PersonSet to write
	correct data to file. 
	@param String outPutFileName - name of the file to use to save to disk
	@param PersonSet ps - Can be either of the subclass of PersonSet
	@returns VOID
	*/
	public static void writeToFile(String outPutFileName, PersonSet ps){
		try{
			FileWriter fileWriterOrder = new FileWriter(outPutFileName);
			fileWriterOrder.write(ps.toString());
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

