import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class EvalVisitor extends CompilerFinalBaseVisitor<Integer> {

	ArrayList<Integer> integer = new ArrayList<Integer>();

	public void printExpr(String string) {
		File file = new File("output.java");
		FileWriter writer;
		try {
			writer = new FileWriter(file, true);
			writer.write(string + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Integer visitMean(CompilerFinalParser.MeanContext ctx) {

		String string = "total = 0;\n" + "               for(int i=0;i<integer.size();i++) {\n"
				+ "                   total = total + integer.get(i);\n" + "               }\n"
				+ "           total = total / integer.size();\n" + " \nSystem.out.println(\"mean = \"+ mean);";

		printExpr(string);
		return 0;
	}

	public Integer visitMin(CompilerFinalParser.MinContext ctx) {

		String string = "min = integer.get(0);\n" + "               for(int i=1;i<integer.size();i++) {\n"
				+ "                   if(integer.get(i)<min) {\n" + "                       min = integer.get(i);\n"
				+ "                   }\n" + "               }\n" + "       \n"
				+ " \nSystem.out.println(\"min = \" +min );";

		printExpr(string);
		return 0;

	}

	public Integer visitMax(CompilerFinalParser.MaxContext ctx) {
		String string = "max = 0;\n" + "               for(int i=0;i<integer.size();i++) {\n"
				+ "                   if(integer.get(i)>max) {\n" + "                       max = integer.get(i);\n"
				+ "                   }\n" + "               }\n" + "       \n"
				+ " \nSystem.out.println(\"max = \" +max);";

		printExpr(string);
		return 0;

	}

	public Integer visitStd(CompilerFinalParser.StdContext ctx) {
		String string = "mean = 0;\n" + "               total = 0;\n"
				+ "               for(int i=0;i<integer.size();i++) {\n"
				+ "                   total = total + integer.get(i);\n" + "               }\n"
				+ "               mean = total / integer.size();\n" + "               sov = 0;\n"
				+ "               temp = 0;\n" + "               for(int i=0;i<integer.size();i++) {\n"
				+ "                   temp = mean - integer.get(i);\n" + "                   temp = temp * temp;\n"
				+ "                   sov = sov + temp;\n" + "               }\n" + "               \n"
				+ "               total = (int) Math.sqrt(sov / integer.size());\n" + "   \n"
				+ " System.out.println(\"std = \" +total);";
		printExpr(string);
		return 0;

	}

	public Integer visitDone(CompilerFinalParser.DoneContext ctx) {
		printExpr(" \nSystem.out.println(\"End File !\");\n}\n" + "}");

		System.exit(0);
		return 0;

	}

	public Integer visitInt(CompilerFinalParser.IntContext ctx) {
		integer.add(Integer.valueOf(ctx.INT().getText()));
		String string = "integer.add(" + Integer.valueOf(ctx.INT().getText()) + ");";
		String show = " System.out.println(\"integer : \" +" + "\"" + Integer.valueOf(ctx.INT().getText()) + "\" "
				+ ");";
		printExpr(string);
		printExpr(show);
		return 0;
	}
}
