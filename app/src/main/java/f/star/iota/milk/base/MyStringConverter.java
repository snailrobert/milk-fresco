package f.star.iota.milk.base;

import com.lzy.okgo.convert.StringConvert;

import java.nio.charset.Charset;

import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.BufferedSource;

public class MyStringConverter extends StringConvert {

    private String charset;


    public MyStringConverter(String charset){
        this.charset = charset;
    }


    @Override
    public String convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) return null;
        if (charset != null){
            BufferedSource bufferedSource = body.source();
            try {
                return bufferedSource.readString(Charset.forName("gb2312"));
            } finally {
                Util.closeQuietly(bufferedSource);
            }
        }
        return body.string();
    }
}
