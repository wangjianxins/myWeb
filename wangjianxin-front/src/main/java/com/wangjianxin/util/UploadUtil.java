package com.wangjianxin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2014/10/10.
 */
public class UploadUtil {

    @Autowired
//    PictemplateManager pictemplateManager;
    /**
     *
     * @paramgetUpload
     *            路径
     * @param getUploadContentType
     *            文件类型
     * @param getUploadFileName
     *            原文件名
     * @return
     * @throws java.io.IOException
     */
    public void uploadImage(MultipartFile file, String getUploadContentType, String getUploadFileName,String newfileName,String imgPath,String imgSize) throws IOException
    {
        String getImagePath="/img/"+imgPath;
       //String getImagePath="/Users/apple/img/"+imgPath;
       //String getImagePath = "C:\\qicheke\\dev\\car\\car\\car-admin\\src\\main\\webapp\\img\\"+imgPath;

        File image = new File(getImagePath);
        if (!image.exists())
        {
            image.mkdir();
        }

        // 得到上传文件的后缀名
        String uploadName = getUploadContentType;

        // 得到文件的新名字
        BufferedImage srcBufferImage = ImageIO.read(file.getInputStream());
        boolean isWrite = true;
        String fileNewName =newfileName; //newfileName.replace("big","small");//newfileName.split("_")[0]+"_"+ newfileName.split("_")[1]+newfileName.split("_")[2].split(".")[0];
        //System.out.println("// 得到文件的新名字 ------------" + fileNewName);

        // 最后返回图片路径
        String imagePath = getImagePath + "/" + fileNewName;

        //System.out.println("imagePath ------------" + imagePath);
        File targetFile = new File(imagePath);

        BufferedImage bufferedImage = null;
        int type = BufferedImage.TYPE_INT_RGB;
        int yw = srcBufferImage.getWidth();  //源图宽
        int yh = srcBufferImage.getHeight();//源图高

        int width = Integer.parseInt(imgSize);
        int height = Integer.parseInt(imgSize);//缩略图尺寸

        //System.out.println("imgSize="+imgSize);

        if (yw > width || yh > height) {
            if (yw * height > yh * width) {
                height = yh * width / yw;
            } else {
                width = yw * height / yh;
            }
        } else {
            width = yw;
            height = yh;
        }

        bufferedImage = new BufferedImage(width, height, type);
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(srcBufferImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null); //生成新尺寸buffer
        isWrite = writeImageFile(bufferedImage, targetFile);//写文件
        g.dispose();

    }

    public static boolean writeImageFile(BufferedImage bufferedImage,File targetFile){
        ImageWriter writer = null;
        ImageOutputStream outputStream = null;
        try {
            ImageTypeSpecifier writeType = ImageTypeSpecifier.createFromRenderedImage(bufferedImage);//缩小后的buffer
            Iterator iterator = ImageIO.getImageWriters(writeType, "JPEG");
            if (!iterator.hasNext()) {
                return false;
            }
            writer = (ImageWriter) iterator.next();
            IIOImage iioImage = new IIOImage(bufferedImage, null, null);//缩小后的buffer
            ImageWriteParam param = writer.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            //param.setCompressionQuality(0.8f);
            param.setCompressionQuality(1f);
            outputStream = ImageIO.createImageOutputStream(targetFile);  //写文件
            writer.setOutput(outputStream);
            writer.write(null, iioImage, param);

        }
        catch (Exception e){
            return false;
        }
        finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.abort();
            }
        }
        return true;
    }

    /**
     * 传入原图名称，，获得一个以时间格式的新名称
     *
     * @param fileName
     *            　原图名称
     * @return
     */
    public String generateFileName(String fileName,String size)
    {
        //String[] sizeArr = size.split("x");
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatDate = format.format(new Date());
        int random = new Random().nextInt(10000);
        int position = fileName.lastIndexOf(".");
        String extension = fileName.substring(position);
        //return formatDate +   random+ "_"+sizeArr[0]+"_"+sizeArr[1] +   extension ;
        return formatDate +"_" +  random+ "_"+size +   extension ;

    }


    public String generateFileName(String fileName)
    {
        //String[] sizeArr = size.split("x");
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatDate = format.format(new Date());
        int random = new Random().nextInt(10000);
        int position = fileName.lastIndexOf(".");
        String extension = fileName.substring(position);//扩展名
        //return formatDate +   random+ "_"+sizeArr[0]+"_"+sizeArr[1] +   extension ;
        return formatDate +"_" +  random +   extension ;

    }
    public String generateTripPDFFileName(String fileName,String callName)
    {
        //String[] sizeArr = size.split("x");

        int position = fileName.lastIndexOf(".");
        String extension = fileName.substring(position);//扩展名
        //return formatDate +   random+ "_"+sizeArr[0]+"_"+sizeArr[1] +   extension ;
        return callName +   extension ;

    }
    //public void main(){
    public static void main(String args[]) {
       // String newfileName="111_222_big.jpg";
        //String fileNewName = newfileName.split("_")[0]+"_"+ newfileName.split("_")[1]+newfileName.split("_")[2].split(".")[0];
          /*  System.out.println(newfileName.split("_")[0]);
            System.out.println(newfileName.split("_")[1]);
            System.out.println(newfileName.replace("big","small"));*/

       /* String a="123,345";
        String[] b = a.split(",");
        for (int i=0;i<b.length;i++){
            System.out.println("i======"+i+"="+b[i]);
        }*/



        Calendar c_begin = new GregorianCalendar();
        Calendar c_end = new GregorianCalendar();
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] weeks = dfs.getWeekdays();

        /*String[] weeks={"星期日"};
        for(int i=0;i<weeks.length;i++){
            System.out.println(weeks[i]);
        }*/

        long  startTime=System.currentTimeMillis();

        c_begin.set(2016, 5, 2); //Calendar的月从0-11，所以4月是3.
        c_end.set(2016, 6, 20); //Calendar的月从0-11，所以5月是4.

        int count = 1;
        c_end.add(Calendar.DAY_OF_YEAR, 1);  //结束日期下滚一天是为了包含最后一天
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while(c_begin.before(c_end)  ){
            //System.out.println("第"+count+"周  日期："+new java.sql.Date(c_begin.getTime().getTime())+","+weeks[c_begin.get(Calendar.DAY_OF_WEEK)]);
            //System.out.println(Calendar.TUESDAY);
            if(c_begin.get(Calendar.DAY_OF_WEEK) == 1) {  //周六=7 ，周日=1
                System.out.println(sdf.format(c_begin.getTime()));
            }
           /* if(c_begin.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
                count++;
            }*/
            c_begin.add(Calendar.DAY_OF_YEAR, 1);
        }

        long  endTime=System.currentTimeMillis();

    }

}
