package com.ngyb.study.test.other;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.UUID;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 14:43
 */
public class PDF {

    public static void main(String[] args) {
        readPDFStr();
    }

    private static void readPDFStr() {
        PDDocument pdDocument = null;
        try {
            pdDocument = PDDocument.load(new File("file\\ngyb.pdf"));
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String text = pdfTextStripper.getText(pdDocument);
            System.out.println(text);
            pdDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提取
     */
    public static void extractImages() {
        String path = "ngyb.pdf";
        File file = new File(path);
        InputStream is = null;
        PDDocument document = null;
        try {
            if (path.endsWith(".pdf")) {
                document = PDDocument.load(file);
                int pageSize = document.getNumberOfPages();
                // 一页一页读取
                for (int i = 0; i < pageSize; i++) {
                    // 文本内容
                    PDFTextStripper stripper = new PDFTextStripper();
                    // 设置按顺序输出
                    stripper.setSortByPosition(true);
                    stripper.setStartPage(i + 1);
                    stripper.setEndPage(i + 1);
                    String text = stripper.getText(document);
                    System.out.println(text.trim());
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

                    // 图片内容
                    PDPage page = document.getPage(i);
                    PDResources resources = page.getResources();
                    Iterable<COSName> cosNames = resources.getXObjectNames();
                    if (cosNames != null) {
                        Iterator<COSName> cosNamesIter = cosNames.iterator();
                        while (cosNamesIter.hasNext()) {
                            COSName cosName = cosNamesIter.next();
                            if (resources.isImageXObject(cosName)) {
                                PDImageXObject Ipdmage = (PDImageXObject) resources.getXObject(cosName);
                                BufferedImage image = Ipdmage.getImage();
                                FileOutputStream out = new FileOutputStream("" + UUID.randomUUID() + ".png");
                                try {
                                    ImageIO.write(image, "png", out);
                                } catch (IOException e) {
                                } finally {
                                    try {
                                        out.close();
                                    } catch (IOException e) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (InvalidPasswordException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static void readPDFTable() {
        String templatePath = "ngyb.pdf";
        String data = "";
        try {
//            List<User> listUser = new ArrayList<>();
            PDDocument document = PDDocument.load(new File(templatePath));
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);
            Rectangle rect = new Rectangle(0, 0, 100000000, 100000000);
            stripper.addRegion("area", rect);
            PDPageTree pages = document.getPages();
            int i = 0;
            for (int j = 0; j < pages.getCount(); j++) {
                PDPage page = pages.get(j);
                stripper.extractRegions(page);
                i++;
                data = stripper.getTextForRegion("area");
                String[] datas = data.split("\r\n");
                for (int k = 0; k < datas.length; k++) {
                    String[] strUser = datas[i].split(" ");
//                    User user = new User();
                    for (int l = 0; l < strUser.length; l++) {
                        //对获取的数据处理
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
