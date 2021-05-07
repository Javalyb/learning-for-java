package priv.lyb;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.apache.commons.io.IOUtils;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.ImageUtility;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

/**
 * Itextpdf工具类
 * 实现图片转pdf、pdf添加水印、压缩pdf为zip、下载zip
 * Create by Eclipse
 */
public class Itext2PDFUtil {

    public final static String pdfCachPath="D:/pdfCachPath";

    /**
     * 批量转换为pdf，每张图片占一页
     * @param pics 图片URL
     * @param targetPDF 要转换为的pdf
     * @param waterMarkName 水印名
     * @param pdfName pdf名称
     * @throws Exception
     */
    public static void toPDF(List<Map<String, String>> pics, String targetPDF, String waterMarkName, String pdfName) throws Exception {
        Itext2PDFUtil.createDir(targetPDF);
        Date date = new Date();
        String realPath = targetPDF + date.getTime() + ".pdf";

        //创建新的PDF文档：A4大小，左右上下边框均为0
        Document doc = new Document(PageSize.A4, 0, 0, 0, 0);
        FileOutputStream fos = new FileOutputStream(realPath);
        //获取PDF书写器
        PdfWriter.getInstance(doc, fos);
        doc.open();
        //图片对象
        Image image = null;
        //遍历
        for (int i = 0; i < pics.size(); i++) {
            Map<String, String> pathMap=pics.get(i);
            String imagePath=pathMap.get("path").toString();
            imagePath = imagePath.replaceAll("\\\\", "/");

            image = Image.getInstance(imagePath);

            float heigth = image.getHeight();
            float width = image.getWidth();
            int percent = getPercent2(heigth, width);
            // 设置图片居中显示
            image.setAlignment(Image.MIDDLE);
            image.scalePercent(percent+3);// 表示是原来图像的比例;
            //添加到PDF文档
            doc.add(image);
            //下一页，每张图片一页
            doc.newPage();
        }
        doc.close();

        try {
            String destFile = pdfCachPath + "/"+ pdfName + ".pdf";
            //添加水印
            Itext2PDFUtil.addWaterMark(realPath, destFile, waterMarkName);

        } catch (Exception e) {
            throw e;
        }finally{
            //关闭文档
            doc.close();
        }

    }

    /**
     *
     * 【功能描述：添加图片和文字水印】 【功能详细描述：功能详细描述】
     * @param srcFile 待加水印文件
     * @param destFile 加水印后存放地址
     * @throws Exception
     */
    public static void addWaterMark(String srcFile, String destFile, String waterMarkName){
        try {
            // 待加水印的文件
            PdfReader reader = new PdfReader(srcFile);
            // 加完水印的文件
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
                    destFile));
            int total = reader.getNumberOfPages() + 1;
            PdfContentByte content;
            // 设置字体
            BaseFont font = BaseFont.createFont(
                    "C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// 使用系统字体
            // 循环对每页插入水印
            for (int i = 1; i < total; i++){

                // 水印的起始,获得pdf最顶层
                content = stamper.getOverContent(i);
                // 开始
                content.beginText();
                // 设置颜色为红色
                content.setColorFill(BaseColor.RED);
                // 设置字体及字号
                content.setFontAndSize(font, 18);
                PdfGState gs = new PdfGState();
                // 设置透明度为
                gs.setFillOpacity(0.3f);
                content.setGState(gs);
                //水印内容
                //String text = "下载人："+ waterMarkName+" 下载时间："  + DateUtil.getDateYDMHMS() + "";
                String text = "下载人："+ waterMarkName+ "";
                // 开始写入水印
                content.showTextAligned(Element.ALIGN_CENTER, text, 200, 680, 45);
                content.showTextAligned(Element.ALIGN_CENTER, text, 200, 400, 45);
                content.showTextAligned(Element.ALIGN_CENTER, text, 200, 120, 45);
                content.endText();
                content.setLineWidth(1f);
                content.stroke();
            }
            stamper.close();
            reader.close();
            //删除原pdf
            File file = new File(srcFile);
            delDir(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 判断文件夹是否存在,如果不存在则创建
     * @param path
     * @return
     */

    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
    }


    /**
     * 第一种解决方案 在不改变图片形状的同时，判断，如果h>w，则按h压缩，否则在w>h或w=h的情况下，按宽度压缩
     *
     * @param h
     * @param w
     * @return
     */

    public static int getPercent(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        if (h > w) {
            p2 = 297 / h * 100;
        } else {
            p2 = 210 / w * 100;
        }
        p = Math.round(p2);
        return p;
    }

    /**
     * 第二种解决方案，统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的，自我认为给客户的效果是最好的
     *
     * @param args
     */
    public static int getPercent2(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        p2 = 530 / w * 100;
        p = Math.round(p2);
        return p;
    }



    /**
     * 压缩文件
     * @param zipFileName 压缩后zip文件
     * @param sourceFileName 源文件
     * @throws Exception
     */
    public static void pdfToZip(HttpServletResponse response, String zipFileName, String sourceFileName, String downName) throws Exception {

        System.out.println("压缩中...");

        // 创建zip输出流
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));

        // 创建缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(out);

        File sourceFile = new File(sourceFileName);

        // 调用函数
        compress(out, bos, sourceFile, sourceFile.getName());

        bos.close();
        out.close();
        System.out.println("压缩完成");

        //下载zip
        //Itext2PDFUtil.downZip(response, zipFileName, downName);
    }


    public static void compress(ZipOutputStream out, BufferedOutputStream bos, File sourceFile, String base) throws Exception {
        // 如果路径为目录（文件夹）
        if (sourceFile.isDirectory()) {

            // 取出文件夹中的文件（或子文件夹）
            File[] flist = sourceFile.listFiles();

            if (flist.length == 0)// 如果文件夹为空，则只需在目的地zip文件中写入一个目录进入点
            {
                System.out.println(base + "/");
                out.putNextEntry(new ZipEntry(base + "/"));
            } else// 如果文件夹不为空，则递归调用compress，文件夹中的每一个文件（或文件夹）进行压缩
            {
                for (int i = 0; i < flist.length; i++) {
                    compress(out, bos, flist[i], base + "/" + flist[i].getName());
                }
            }
        } else// 如果不是目录（文件夹），即为文件，则先写入目录进入点，之后将文件写入zip文件中
        {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream fos = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fos);

            int tag;
            System.out.println(base);
            // 将源文件写入到zip文件中
            while ((tag = bis.read()) != -1) {
                bos.write(tag);
            }
            bis.close();
            fos.close();

        }
    }

    /**
     * 下载压缩包
     * @param response
     * @param dirOrFile zip文件
     * @param targetFullZipName 下载后的文件名
     */
    public static void downZip(HttpServletResponse response, String dirOrFile, String targetFullZipName) {
        try {
            System.out.println("开始下载zip文件");
            File file = new File(dirOrFile);
            FileInputStream fis;
            try {
                fis = new FileInputStream(file);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();

                response.reset();
                response.addHeader("Content-Disposition",
                        "attachment;filename=" + URLEncoder.encode(targetFullZipName, "UTF-8"));
                response.addHeader("Content-Length", "" + file.length());
                OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                outputStream.write(buffer);
                outputStream.flush();
                outputStream.close();
                IOUtils.closeQuietly(outputStream);
                System.out.println("下载zip文件完成");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归获取目录下的所有文件及子目录下所有文件
     * @param dir 将要获取的文件目录
     */
    public static Map<String, Object> getFiles(String fileDir) {
        List<File> fileList = new ArrayList<File>();
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return null;
        }
        // 遍历，目录下的所有文件
        for (File f : files) {
            String fileName=f.getName();
            String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
            if(!prefix.equals("ini")){
                fileList.add(f);
            }
        }
        Map<String, Object> results=new HashMap<String, Object>();
        List<Map<String, String>> result1=new ArrayList<Map<String, String>>();
        List<Map<String, String>> result2=new ArrayList<Map<String, String>>();

        for (int i = 0; i < fileList.size(); i++) {
            Map<String, String> map1=new HashMap<String,String>();
            map1.put("id", "root"+String.valueOf(i));
            map1.put("path", fileList.get(i).getPath());
            map1.put("name", fileList.get(i).getName());

            if (fileList.get(i).isDirectory()) {
                File[] f2 = fileList.get(i).listFiles();// 获取目录下的所有文件或文件夹
                for (int j = 0; j < f2.length; j++) {
                    Map<String, String> map2=new HashMap<String,String>();
                    map2.put("id", String.valueOf(i)+String.valueOf(j));
                    map2.put("path", f2[j].getPath());
                    map2.put("name", f2[j].getName());
                    map2.put("pId", "root"+String.valueOf(i));
                    if(!map2.isEmpty()){
                        result2.add(map2);
                    }
                }
            }
            result1.add(map1);
        }
        results.put("result1", result1);
        results.put("result2", result2);
        return results;
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     */
    public static boolean delDir(File dir) {

        if(dir.isDirectory()) {
            // 获取子文件/目录
            File[] subFiles = dir.listFiles();
            // 遍历该目录
            for (File subFile : subFiles) {
                // 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除. 如果这是一个非空目录, 多次
                // 递归清空其内容后再删除
                delDir(subFile);
            }
        }

        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     * 将指定pdf文件的首页转换为指定路径的缩略图
     *
     * @param filepath 原文件路径，例如d:/test.pdf
     * @param imagepath 图片生成路径，例如 d:/
     * @param zoom 缩略图显示倍数，1表示不缩放，0.3则缩小到30%
     * @return 生成图片名称列表
     */
    public static void tranfer(String filepath, String imagepath, float zoom) throws PDFException,
            PDFSecurityException, IOException, InterruptedException {
        // ICEpdf document class
        org.icepdf.core.pobjects.Document document = null;
        float rotation = 0f;
        document = new org.icepdf.core.pobjects.Document();
        document.setFile(filepath);
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            BufferedImage img = (BufferedImage) document.getPageImage(i, GraphicsRenderingHints.SCREEN, Page.BOUNDARY_CROPBOX, rotation, zoom);
            Iterator iter = ImageIO.getImageWritersBySuffix("jpg");
            ImageWriter writer = (ImageWriter) iter.next();
            String filename = filepath.substring(filepath.lastIndexOf("/")+1);
            System.out.println(imagepath + filename + ".jpg");
            File outFile = new File(imagepath + filename + ".jpg");
            if(!outFile.exists()){
                outFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(outFile);
            ImageOutputStream outImage = ImageIO.createImageOutputStream(out);
            writer.setOutput(outImage);
            writer.write(new IIOImage(img, null, null));
        }
    }


    public static boolean mergePdfFiles(String[] files, String newfile) {
        boolean retValue = false;
        Document document = null;
        try {
             //document = new Document(new PdfReader(files[0]).getPageSize(1));
             //document = new Document(PageSize.A4, 0, 0, 0, 0);
             document = new Document(new Rectangle(280, 480));
             PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));
             document.open();
             for (int i = 0; i < files.length; i++) {
                     PdfReader reader = new PdfReader(files[i]);
                     int n = reader.getNumberOfPages();
                     for (int j = 1; j <= n; j++) {
                             document.newPage();
                             PdfImportedPage page = copy.getImportedPage(reader, j);
                             copy.addPage(page);
                         }
                 }
             retValue = true;
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             document.close();
         }
         return retValue;
     }

    /*public static void main(String[] args) {
        File file = new File("//Users//liuyingbo//Downloads//333//1");
        File [] files =  file.listFiles();
        String[] fileArr = new String [file.listFiles().length];
        for (int i = 0; i < files.length; i++) {
            fileArr[i]=files[i].getAbsolutePath();
        }
        mergePdfFiles(fileArr, "//Users//liuyingbo//Downloads//333//333.pdf");
    }*/

    private static void createPic1(Document document,List<String> list) {
        // try {
        // Image image =null;
           /* for (String s : list) {
                image = Image.getInstance(s);
                image.setAbsolutePosition(0, 0);//坐标
                //  image.setRotation(-20);//旋转 弧度
                // image.setRotationDegrees(-90);//旋转 角度
                float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
                float documentHeight = documentWidth / 600 * 300;// 重新设置宽高
                image.scaleAbsolute(281, 425);// 重新设置宽高
                document.add(image);
                document.newPage();
            }*/
        list.stream().peek(peek ->
        {
            Image  image = null;
            try {
                /*image = Image.getInstance(peek);
                image.setAbsolutePosition(0, 0);
                //image.setAlignment(Image.MIDDLE);
                image.scaleAbsolute(280, 425);// 重新设置宽高
                //image.scaleToFit(document.getPageSize().getWidth(),document.getPageSize().getHeight()-20);
                image.setBottom(0);
                image.setBorderWidthBottom(0);*/

                image = Image.getInstance(peek);
                image.setAbsolutePosition(0, 0);
                float heigth = image.getHeight();
                float width = image.getWidth();
                image.scaleAbsolute(280, 425);
                image.setAlignment(Element.ALIGN_CENTER);
                //image.scalePercent(50, 100);
//                image.scaleToFit(PageSize.A4);
                document.add(image);
                document.newPage();
            } catch (Exception e) {
                //  e.printStackTrace();
            }
        }).collect(Collectors.toList());
        // } catch (Exception ex) {

        //}
    }

    public static void image3pdf(String pdfUrl, List<String> list) throws DocumentException, IOException {
//        Document document = new Document(new Rectangle(280, 425));
        //Document document = new Document(new Rectangle(280, 425));
        Rectangle rectangle = new Rectangle(280, 425);
        rectangle.setBorderWidthBottom(0f);
        Document document = new Document(rectangle);
        File file =new File (pdfUrl);
        System.out.println(file.exists());
        if (file.exists()){
            file.delete();
        }
        OutputStream os = new FileOutputStream(file);
        PdfWriter.getInstance(document, os);
        document.open();
        createPic1(document,list);
        document.close();
    }

    public static File mulFile2One(List<File> files, String targetPath) throws IOException {
        // pdf合并工具类
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        for (File f : files) {
            if (f.exists() && f.isFile()) {
                // 循环添加要合并的pdf
                mergePdf.addSource(f);
            }
        }
        // 设置合并生成pdf文件名称
        mergePdf.setDestinationFileName(targetPath);
        // 合并pdf
        mergePdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        return new File(targetPath);
    }

    public static void main(String[] args) throws Exception{
        Date startTime = new Date();
        File file = new File("//Users//liuyingbo//Downloads//333//4");
        File [] files =  file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getAbsolutePath());
            tranfer(files[i].getAbsolutePath(), "//Users//liuyingbo//Downloads//333//3//", 1f);
        }

        File [] picFiles = new File("//Users//liuyingbo//Downloads//333//3//").listFiles();
        String[] fileArr = new String [picFiles.length];
        List<String> lists = Arrays.stream(picFiles).map(o -> o.getAbsolutePath()).collect(Collectors.toList());

        image3pdf("//Users//liuyingbo//Downloads//333//4.pdf", lists);

        Date endTime = new Date();
        System.out.println(endTime.getTime()-startTime.getTime());


        /*File file = new File("//Users//liuyingbo//Downloads//333//4");
        File [] files =  file.listFiles();
        mulFile2One(Arrays.stream(files).collect(Collectors.toList()),"//Users//liuyingbo//Downloads//333//5.pdf");*/

    }



}


