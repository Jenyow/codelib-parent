package samples.test;

import java.io.File;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

import org.docx4j.XmlUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.io.SaveToZipFile;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.CTBookmark;
import org.docx4j.wml.CTMarkupRange;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.P.Hyperlink;
import org.docx4j.wml.R;
import org.junit.Test;

/**
 * 标签跳转
 * @author zhanyao
 *
 */
public class BookmarkAddTest {

	public static JAXBContext context = org.docx4j.jaxb.Context.jc;

	@Test
	public void testBookmarkAdd() throws Docx4JException {
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

		String outputfilepath = System.getProperty("user.dir") + "/docs/BookmarkAdd/output/OUT_bookmarkAdd.docx";

		wordMLPackage.getMainDocumentPart().addParagraphOfText("x");
		wordMLPackage.getMainDocumentPart().addParagraphOfText("x");
		wordMLPackage.getMainDocumentPart().addParagraphOfText("hello world");
		P p = (P) wordMLPackage.getMainDocumentPart().getContent().get(2);
		R r = (R) p.getContent().get(0);

		String bookmarkName = "abcd";
		bookmarkRun(p, r, bookmarkName, 123);

		wordMLPackage.getMainDocumentPart().addParagraphOfText("x");
		wordMLPackage.getMainDocumentPart().addParagraphOfText("x");

		// Now add an internal hyperlink to it
		Hyperlink h = MainDocumentPart.hyperlinkToBookmark(bookmarkName, "link to bookmark");
		wordMLPackage.getMainDocumentPart().addParagraphOfText("some text").getContent().add(h);

		System.out.println(XmlUtils.marshaltoString(p, true, false, context));

		wordMLPackage.save(new File(outputfilepath));
	}

	/**
	 * Surround the specified r in the specified p with a bookmark (with specified
	 * name and id)
	 * 
	 * @param p
	 * @param r
	 * @param name
	 * @param id
	 */
	public static void bookmarkRun(P p, R r, String name, int id) {

		// Find the index
		int index = p.getContent().indexOf(r);

		if (index < 0) {
			System.out.println("P does not contain R!");
			return;
		}

		ObjectFactory factory = Context.getWmlObjectFactory();
		BigInteger ID = BigInteger.valueOf(id);

		// Add bookmark end first
		CTMarkupRange mr = factory.createCTMarkupRange();
		mr.setId(ID);
		JAXBElement<CTMarkupRange> bmEnd = factory.createBodyBookmarkEnd(mr);
		p.getContent().add(index + 1, bmEnd);

		// Next, bookmark start
		CTBookmark bm = factory.createCTBookmark();
		bm.setId(ID);
		bm.setName(name);
		JAXBElement<CTBookmark> bmStart = factory.createBodyBookmarkStart(bm);
		p.getContent().add(index, bmStart);

	}
}
