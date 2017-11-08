package exam.ast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class Code2Pic {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Usage: java exam.ast.Code2Pic <SourceFile>");
			return;
		}
		File source = new File(args[0]);
		source.setReadOnly();
		String dirPath = source.getParent();
		String filename = source.getName();
		String outFilename = filename.substring(0, filename.lastIndexOf(".")) + ".bmp";
		FileOutputStream outPic;
		try {
			outPic = new FileOutputStream(dirPath + File.separator + outFilename);
			parse(args[0], outPic);
			outPic.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static void parse(String sourcePath, FileOutputStream outPic) throws IOException{
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		String srcStr = readAll(sourcePath);
		parser.setSource(srcStr.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		CompilationUnit unit = (CompilationUnit) parser.createAST(new NullProgressMonitor());
		unit.accept(new AllVisitor(outPic));
	}
	

	public static String readAll(final String path) throws IOException {
	    return Files.lines(Paths.get(path), Charset.forName("UTF-8"))
	        .collect(Collectors.joining(System.getProperty("line.separator")));
	}
}
