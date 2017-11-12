import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by chunk on 2017/11/12.
 */
public class TEST {
    public static void main(String[] args){

        Map<String,List<String>> map = Maps.newHashMap();
        map.put("1", Lists.newArrayList("1","2"));
        System.out.print(map.toString());
    }
}
