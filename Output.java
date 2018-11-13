import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;

public class Final {

	public static void main(String[] args) throws Exception {
		String inputFile = args[0];
		InputStream is = System.in;

		is = new FileInputStream(inputFile);

		File file = new File("output.java");

		file.createNewFile();

		FileWriter writer = new FileWriter(file, true);
		writer.write("import java.util.ArrayList;\nimport java.util.Collections;\npublic class output {\n"
				+ "  public static void main(String argv[]) {\nArrayList<Integer> integer = new ArrayList<Integer>();\n"
				+ "		int total;\n" + "		int max;\n" + "		int min;\n" + "		int mean;\n"
				+ "		int sov;\n" + "		int temp;\n" + "		");
		writer.close();
		ANTLRInputStream input = new ANTLRInputStream(is);
		CompilerFinalLexer lexer = new CompilerFinalLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CompilerFinalParser parser = new CompilerFinalParser(tokens);
		ParseTree tree = parser.prog();

		EvalVisitor eval = new EvalVisitor();
		eval.visit(tree);

		FileWriter writers = new FileWriter(file, true);
		writers.write(" \n}\n" + "}");
		writers.close();
	}
}