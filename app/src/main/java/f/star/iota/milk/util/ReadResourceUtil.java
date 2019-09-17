package f.star.iota.milk.util;

import android.support.annotation.RawRes;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import f.star.iota.milk.MyApp;

public class ReadResourceUtil {

    public static String readResource(@RawRes int id){
        InputStream input = MyApp.mContext.getResources().openRawResource(id);
        Reader reader =new InputStreamReader(input);
        StringBuffer stringBuffer = new StringBuffer();
        char b[]=new char[1024];
        int len = 0 ;
        try {
            while ((len = reader.read(b))!= -1){
                stringBuffer.append(b);
            }
        }catch (IOException e){
            Log.e("ReadingFile","IOException");
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                Log.e("ReadingFile","IOException");
            }
        }
        return  stringBuffer.toString();
    }


    public static String readBufferResource(@RawRes int id){
        InputStream input = MyApp.mContext.getResources().openRawResource(id);
        BufferedReader  reader = new BufferedReader(new InputStreamReader(input));
        StringBuffer stringBuffer = new StringBuffer();
        String str;
        try {
            while ((str = reader.readLine()) != null){
                stringBuffer.append(str);
            }
        }catch (IOException e){
            Log.e("ReadingFile","IOException");
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                Log.e("ReadingFile","IOException");
            }
        }
        return  stringBuffer.toString();
    }
}
