package exam.ast;

import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EmptyStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.LabeledStatement;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.MethodRef;
import org.eclipse.jdt.core.dom.MethodRefParameter;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.UnionType;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.WildcardType;

public class AllVisitor extends ASTVisitor {

	FileOutputStream outPic;

	public AllVisitor(FileOutputStream outPic2) {
		super();
		this.outPic = outPic2;
	}

	enum CodeElements {
		AnnotationTypeDeclaration, AnnotationTypeMemberDeclaration, AnonymousClassDeclaration, ArrayAccess, ArrayCreation, ArrayInitializer, ArrayType, AssertStatement, Assignment, Block, BlockComment, BooleanLiteral, BreakStatement, CastExpression, CatchClause, CharacterLiteral, ClassInstanceCreation, CompilationUnit, ConditionalExpression, ConstructorInvocation, ContinueStatement, DoStatement, EmptyStatement, EnhancedForStatement, EnumConstantDeclaration, EnumDeclaration, ExpressionStatement, FieldAccess, FieldDeclaration, ForStatement, IfStatement, ImportDeclaration, InfixExpression, Initializer, InstanceofExpression, Javadoc, LabeledStatement, LineComment, MarkerAnnotation, MemberRef, MemberValuePair, MethodDeclaration, MethodInvocation, MethodRef, MethodRefParameter, Modifier, NormalAnnotation, NullLiteral, NumberLiteral, PackageDeclaration, ParameterizedType, ParenthesizedExpression, PostfixExpression, PrefixExpression, PrimitiveType, QualifiedName, QualifiedType, ReturnStatement, SimpleName, SimpleType, SingleMemberAnnotation, SingleVariableDeclaration, StringLiteral, SuperConstructorInvocation, SuperFieldAccess, SuperMethodInvocation, SwitchCase, SwitchStatement, SynchronizedStatement, TagElement, TextElement, ThisExpression, ThrowStatement, TryStatement, TypeDeclaration, TypeDeclarationStatement, TypeLiteral, TypeParameter, UnionType, VariableDeclarationExpression, VariableDeclarationFragment, VariableDeclarationStatement, WhileStatement, WildcardType,
	};

	@Override
	public void endVisit(AnnotationTypeDeclaration node) {
		try {
			outPic.write(CodeElements.AnnotationTypeDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.endVisit(node);
	}

	@Override
	public void endVisit(AnnotationTypeMemberDeclaration node) {
		try {
			outPic.write(CodeElements.AnnotationTypeMemberDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(AnonymousClassDeclaration node) {
		try {
			outPic.write(CodeElements.AnonymousClassDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ArrayAccess node) {
		try {
			outPic.write(CodeElements.ArrayAccess.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ArrayCreation node) {
		try {
			outPic.write(CodeElements.ArrayCreation.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ArrayInitializer node) {
		try {
			outPic.write(CodeElements.ArrayInitializer.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ArrayType node) {
		try {
			outPic.write(CodeElements.ArrayType.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(AssertStatement node) {
		try {
			outPic.write(CodeElements.AssertStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(Assignment node) {
		try {
			outPic.write(CodeElements.Assignment.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(Block node) {
		try {
			outPic.write(CodeElements.Block.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(BlockComment node) {
		try {
			outPic.write(CodeElements.BlockComment.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(BooleanLiteral node) {
		try {
			outPic.write(CodeElements.BooleanLiteral.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(BreakStatement node) {
		try {
			outPic.write(CodeElements.BreakStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(CastExpression node) {
		try {
			outPic.write(CodeElements.CastExpression.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(CatchClause node) {
		try {
			outPic.write(CodeElements.CatchClause.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(CharacterLiteral node) {
		try {
			outPic.write(CodeElements.CharacterLiteral.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ClassInstanceCreation node) {
		try {
			outPic.write(CodeElements.ClassInstanceCreation.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(CompilationUnit node) {
		try {
			outPic.write(CodeElements.CompilationUnit.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ConditionalExpression node) {
		try {
			outPic.write(CodeElements.ConditionalExpression.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ConstructorInvocation node) {
		try {
			outPic.write(CodeElements.ConstructorInvocation.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ContinueStatement node) {
		try {
			outPic.write(CodeElements.ContinueStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(DoStatement node) {
		try {
			outPic.write(CodeElements.DoStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(EmptyStatement node) {
		try {
			outPic.write(CodeElements.EmptyStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(EnhancedForStatement node) {
		try {
			outPic.write(CodeElements.EnhancedForStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(EnumConstantDeclaration node) {
		try {
			outPic.write(CodeElements.EnumConstantDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(EnumDeclaration node) {
		try {
			outPic.write(CodeElements.EnumDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ExpressionStatement node) {
		try {
			outPic.write(CodeElements.ExpressionStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(FieldAccess node) {
		try {
			outPic.write(CodeElements.FieldAccess.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(FieldDeclaration node) {
		try {
			outPic.write(CodeElements.FieldDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ForStatement node) {
		try {
			outPic.write(CodeElements.ForStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(IfStatement node) {
		try {
			outPic.write(CodeElements.IfStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ImportDeclaration node) {
		try {
			outPic.write(CodeElements.ImportDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(InfixExpression node) {
		try {
			outPic.write(CodeElements.InfixExpression.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(Initializer node) {
		try {
			outPic.write(CodeElements.Initializer.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(InstanceofExpression node) {
		try {
			outPic.write(CodeElements.InstanceofExpression.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(Javadoc node) {
		try {
			outPic.write(CodeElements.Javadoc.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(LabeledStatement node) {
		try {
			outPic.write(CodeElements.LabeledStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(LineComment node) {
		try {
			outPic.write(CodeElements.LineComment.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(MarkerAnnotation node) {
		try {
			outPic.write(CodeElements.MarkerAnnotation.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(MemberRef node) {
		try {
			outPic.write(CodeElements.MemberRef.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(MemberValuePair node) {
		try {
			outPic.write(CodeElements.MemberValuePair.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(MethodDeclaration node) {
		try {
			outPic.write(CodeElements.MethodDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(MethodInvocation node) {
		try {
			outPic.write(CodeElements.MethodInvocation.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(MethodRef node) {
		try {
			outPic.write(CodeElements.MethodRef.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(MethodRefParameter node) {
		try {
			outPic.write(CodeElements.MethodRefParameter.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(Modifier node) {
		try {
			outPic.write(CodeElements.Modifier.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(NormalAnnotation node) {
		try {
			outPic.write(CodeElements.NormalAnnotation.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(NullLiteral node) {
		try {
			outPic.write(CodeElements.NullLiteral.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(NumberLiteral node) {
		try {
			outPic.write(CodeElements.NumberLiteral.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(PackageDeclaration node) {
		try {
			outPic.write(CodeElements.PackageDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ParameterizedType node) {
		try {
			outPic.write(CodeElements.ParameterizedType.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ParenthesizedExpression node) {
		try {
			outPic.write(CodeElements.ParenthesizedExpression.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(PostfixExpression node) {
		try {
			outPic.write(CodeElements.PostfixExpression.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(PrefixExpression node) {
		try {
			outPic.write(CodeElements.PrefixExpression.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(PrimitiveType node) {
		try {
			outPic.write(CodeElements.PrimitiveType.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(QualifiedName node) {
		try {
			outPic.write(CodeElements.QualifiedName.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(QualifiedType node) {
		try {
			outPic.write(CodeElements.QualifiedType.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ReturnStatement node) {
		try {
			outPic.write(CodeElements.ReturnStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SimpleName node) {
		try {
			outPic.write(CodeElements.SimpleName.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SimpleType node) {
		try {
			outPic.write(CodeElements.SimpleType.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SingleMemberAnnotation node) {
		try {
			outPic.write(CodeElements.SingleMemberAnnotation.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SingleVariableDeclaration node) {
		try {
			outPic.write(CodeElements.SingleVariableDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(StringLiteral node) {
		try {
			outPic.write(CodeElements.StringLiteral.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SuperConstructorInvocation node) {
		try {
			outPic.write(CodeElements.SuperConstructorInvocation.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SuperFieldAccess node) {
		try {
			outPic.write(CodeElements.SuperFieldAccess.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SuperMethodInvocation node) {
		try {
			outPic.write(CodeElements.SuperMethodInvocation.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SwitchCase node) {
		try {
			outPic.write(CodeElements.SwitchCase.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SwitchStatement node) {
		try {
			outPic.write(CodeElements.SwitchStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(SynchronizedStatement node) {
		try {
			outPic.write(CodeElements.SynchronizedStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(TagElement node) {
		try {
			outPic.write(CodeElements.TagElement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(TextElement node) {
		try {
			outPic.write(CodeElements.TextElement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ThisExpression node) {
		try {
			outPic.write(CodeElements.ThisExpression.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(ThrowStatement node) {
		try {
			outPic.write(CodeElements.ThrowStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(TryStatement node) {
		try {
			outPic.write(CodeElements.TryStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(TypeDeclaration node) {
		try {
			outPic.write(CodeElements.TypeDeclaration.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(TypeDeclarationStatement node) {
		try {
			outPic.write(CodeElements.TypeDeclarationStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(TypeLiteral node) {
		try {
			outPic.write(CodeElements.TypeLiteral.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(TypeParameter node) {
		try {
			outPic.write(CodeElements.TypeParameter.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(UnionType node) {
		try {
			outPic.write(CodeElements.UnionType.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(VariableDeclarationExpression node) {
		try {
			outPic.write(CodeElements.VariableDeclarationExpression.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(VariableDeclarationFragment node) {
		try {
			outPic.write(CodeElements.VariableDeclarationFragment.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(VariableDeclarationStatement node) {
		try {
			outPic.write(CodeElements.VariableDeclarationStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(WhileStatement node) {
		try {
			outPic.write(CodeElements.WhileStatement.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public void endVisit(WildcardType node) {
		try {
			outPic.write(CodeElements.WildcardType.ordinal()
					+ CodeElements.values().length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.endVisit(node);
	}

	@Override
	public boolean visit(AnnotationTypeDeclaration node) {
		try {
			outPic.write(CodeElements.AnnotationTypeDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(AnnotationTypeMemberDeclaration node) {
		try {
			outPic.write(CodeElements.AnnotationTypeMemberDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(AnonymousClassDeclaration node) {
		try {
			outPic.write(CodeElements.AnonymousClassDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ArrayAccess node) {
		try {
			outPic.write(CodeElements.ArrayAccess.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ArrayCreation node) {
		try {
			outPic.write(CodeElements.ArrayCreation.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ArrayInitializer node) {
		try {
			outPic.write(CodeElements.ArrayInitializer.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ArrayType node) {
		try {
			outPic.write(CodeElements.ArrayType.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(AssertStatement node) {
		try {
			outPic.write(CodeElements.AssertStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(Assignment node) {
		try {
			outPic.write(CodeElements.Assignment.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(Block node) {
		try {
			outPic.write(CodeElements.Block.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(BlockComment node) {
		try {
			outPic.write(CodeElements.BlockComment.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(BooleanLiteral node) {
		try {
			outPic.write(CodeElements.BooleanLiteral.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(BreakStatement node) {
		try {
			outPic.write(CodeElements.BreakStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(CastExpression node) {
		try {
			outPic.write(CodeElements.CastExpression.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(CatchClause node) {
		try {
			outPic.write(CodeElements.CatchClause.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(CharacterLiteral node) {
		try {
			outPic.write(CodeElements.CharacterLiteral.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ClassInstanceCreation node) {
		try {
			outPic.write(CodeElements.ClassInstanceCreation.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(CompilationUnit node) {
		try {
			outPic.write(CodeElements.CompilationUnit.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ConditionalExpression node) {
		try {
			outPic.write(CodeElements.ConditionalExpression.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ConstructorInvocation node) {
		try {
			outPic.write(CodeElements.ConstructorInvocation.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ContinueStatement node) {
		try {
			outPic.write(CodeElements.ContinueStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(DoStatement node) {
		try {
			outPic.write(CodeElements.DoStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(EmptyStatement node) {
		try {
			outPic.write(CodeElements.EmptyStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(EnhancedForStatement node) {
		try {
			outPic.write(CodeElements.EnhancedForStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(EnumConstantDeclaration node) {
		try {
			outPic.write(CodeElements.EnumConstantDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(EnumDeclaration node) {
		try {
			outPic.write(CodeElements.EnumDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ExpressionStatement node) {
		try {
			outPic.write(CodeElements.ExpressionStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(FieldAccess node) {
		try {
			outPic.write(CodeElements.FieldAccess.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		try {
			outPic.write(CodeElements.FieldDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ForStatement node) {
		try {
			outPic.write(CodeElements.ForStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(IfStatement node) {
		try {
			outPic.write(CodeElements.IfStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ImportDeclaration node) {
		try {
			outPic.write(CodeElements.ImportDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(InfixExpression node) {
		try {
			outPic.write(CodeElements.InfixExpression.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(Initializer node) {
		try {
			outPic.write(CodeElements.Initializer.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(InstanceofExpression node) {
		try {
			outPic.write(CodeElements.InstanceofExpression.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(Javadoc node) {
		try {
			outPic.write(CodeElements.Javadoc.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(LabeledStatement node) {
		try {
			outPic.write(CodeElements.LabeledStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(LineComment node) {
		try {
			outPic.write(CodeElements.LineComment.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(MarkerAnnotation node) {
		try {
			outPic.write(CodeElements.MarkerAnnotation.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(MemberRef node) {
		try {
			outPic.write(CodeElements.MemberRef.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(MemberValuePair node) {
		try {
			outPic.write(CodeElements.MemberValuePair.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		try {
			outPic.write(CodeElements.MethodDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(MethodInvocation node) {
		try {
			outPic.write(CodeElements.MethodInvocation.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(MethodRef node) {
		try {
			outPic.write(CodeElements.MethodRef.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(MethodRefParameter node) {
		try {
			outPic.write(CodeElements.MethodRefParameter.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(Modifier node) {
		try {
			outPic.write(CodeElements.Modifier.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(NormalAnnotation node) {
		try {
			outPic.write(CodeElements.NormalAnnotation.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(NullLiteral node) {
		try {
			outPic.write(CodeElements.NullLiteral.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(NumberLiteral node) {
		try {
			outPic.write(CodeElements.NumberLiteral.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(PackageDeclaration node) {
		try {
			outPic.write(CodeElements.PackageDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ParameterizedType node) {
		try {
			outPic.write(CodeElements.ParameterizedType.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ParenthesizedExpression node) {
		try {
			outPic.write(CodeElements.ParenthesizedExpression.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(PostfixExpression node) {
		try {
			outPic.write(CodeElements.PostfixExpression.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(PrefixExpression node) {
		try {
			outPic.write(CodeElements.PrefixExpression.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(PrimitiveType node) {
		try {
			outPic.write(CodeElements.PrimitiveType.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(QualifiedName node) {
		try {
			outPic.write(CodeElements.QualifiedName.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(QualifiedType node) {
		try {
			outPic.write(CodeElements.QualifiedType.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ReturnStatement node) {
		try {
			outPic.write(CodeElements.ReturnStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SimpleName node) {
		try {
			outPic.write(CodeElements.SimpleName.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SimpleType node) {
		try {
			outPic.write(CodeElements.SimpleType.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SingleMemberAnnotation node) {
		try {
			outPic.write(CodeElements.SingleMemberAnnotation.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SingleVariableDeclaration node) {
		try {
			outPic.write(CodeElements.SingleVariableDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(StringLiteral node) {
		try {
			outPic.write(CodeElements.StringLiteral.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SuperConstructorInvocation node) {
		try {
			outPic.write(CodeElements.SuperConstructorInvocation.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SuperFieldAccess node) {
		try {
			outPic.write(CodeElements.SuperFieldAccess.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SuperMethodInvocation node) {
		try {
			outPic.write(CodeElements.SuperMethodInvocation.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SwitchCase node) {
		try {
			outPic.write(CodeElements.SwitchCase.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SwitchStatement node) {
		try {
			outPic.write(CodeElements.SwitchStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(SynchronizedStatement node) {
		try {
			outPic.write(CodeElements.SynchronizedStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(TagElement node) {
		try {
			outPic.write(CodeElements.TagElement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(TextElement node) {
		try {
			outPic.write(CodeElements.TextElement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ThisExpression node) {
		try {
			outPic.write(CodeElements.ThisExpression.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ThrowStatement node) {
		try {
			outPic.write(CodeElements.ThrowStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(TryStatement node) {
		try {
			outPic.write(CodeElements.TryStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.visit(node);
	}

	@Override
	public boolean visit(TypeDeclaration node) {
		try {
			outPic.write(CodeElements.TypeDeclaration.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(TypeDeclarationStatement node) {
		try {
			outPic.write(CodeElements.TypeDeclarationStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(TypeLiteral node) {
		try {
			outPic.write(CodeElements.TypeLiteral.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(TypeParameter node) {
		try {
			outPic.write(CodeElements.TypeParameter.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(UnionType node) {
		try {
			outPic.write(CodeElements.UnionType.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(VariableDeclarationExpression node) {
		try {
			outPic.write(CodeElements.VariableDeclarationExpression.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.visit(node);
	}

	@Override
	public boolean visit(VariableDeclarationFragment node) {
		try {
			outPic.write(CodeElements.VariableDeclarationFragment.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.visit(node);
	}

	@Override
	public boolean visit(VariableDeclarationStatement node) {
		try {
			outPic.write(CodeElements.VariableDeclarationStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.visit(node);
	}
	@Override
	public boolean visit(WhileStatement node) {
		try {
			outPic.write(CodeElements.WhileStatement.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.visit(node);
	}

	@Override
	public boolean visit(WildcardType node) {
		try {
			outPic.write(CodeElements.WildcardType.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.visit(node);
	}

}
