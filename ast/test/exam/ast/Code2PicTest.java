package exam.ast;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class Code2PicTest {

	@Test
	public void testMain() {
		String args[] = {"src/exam/ast/AllVisitor.java"};
		Code2Pic.main(args);
		File outPic = new File("src/exam/ast/AllVisitor.bmp");
		assertTrue(outPic.exists());
	}

}
