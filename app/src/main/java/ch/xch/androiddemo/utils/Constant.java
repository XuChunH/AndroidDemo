package ch.xch.androiddemo.utils;

/**
 * Created by XCH on 2014/12/3.
 */
public interface Constant {

    public static String CATEGORY_DEFAULT = "cn.xch.category.default";

    public static String ACTION_DEFAULT = "cn.xch.action.default";

    public static String TEXT_TITLE = "title";
    public static String TEXT_INTENT = "intent";
    public static String TEXT_SETTING = "setting";
    public static String TEXT_THEME = "theme";

    public static int THEME_DARK = 0;
    public static int THEME_LIGHT = 1;

    public static final String TEST_DATA_JSON = "{\n" +
            "    \"action\" : \"get\",\n" +
            "    \"application\" : \"4d7e4ba0-dc4a-11e3-90d5-e1ffbaacdaf5\",\n" +
            "    \"params\" : {\n" +
            "    \"limit\" : [ \"20\" ]\n" +
            "    },\n" +
            "    \"path\" : \"/users\",\n" +
            "    \"uri\" : \"https://a1.easemob.com/easemob-demo/chatdemoui/users?ql=select+*+from+null&limit=20\",\n" +
            "    \"entities\" : [ {\n" +
            "    \"uuid\" : \"fff15c10-df37-11e3-843f-e5b88d483c56\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400491736144,\n" +
            "    \"modified\" : 1409055655016,\n" +
            "    \"username\" : \"wjglpgecxu\",\n" +
            "    \"activated\" : true,\n" +
            "    \"nickname\" : \"wjglpgecxu\",\n" +
            "    \"notifier_name\" : \"chatdemoui_dev\"\n" +
            "  }, {\n" +
            "    \"uuid\" : \"4cca8760-df3c-11e3-8712-9f7483b2df95\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400493583061,\n" +
            "    \"modified\" : 1400493583061,\n" +
            "    \"username\" : \"pfs5afofrf\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"5918fb7a-df3f-11e3-94d1-1f977e72d55c\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400494892199,\n" +
            "    \"modified\" : 1407465728550,\n" +
            "    \"username\" : \"igm8dl8m2e\",\n" +
            "    \"activated\" : true,\n" +
            "    \"nickname\" : \"sadsadsa\",\n" +
            "    \"notification_display_style\" : 0,\n" +
            "    \"notification_no_disturbing\" : false\n" +
            "  }, {\n" +
            "    \"uuid\" : \"ee6e5a3a-df3f-11e3-bbe9-d3a806493d4a\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400495142739,\n" +
            "    \"modified\" : 1400495142739,\n" +
            "    \"username\" : \"lgqieuevag\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"6d3ba2ea-df41-11e3-b304-eb2e9192a84a\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400495784974,\n" +
            "    \"modified\" : 1400495784974,\n" +
            "    \"username\" : \"quqx6qjmb2\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"51b663ba-df42-11e3-8470-cd9881131147\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400496168299,\n" +
            "    \"modified\" : 1400496168299,\n" +
            "    \"username\" : \"y0fchl0ps9\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"b8b1c32a-df42-11e3-b375-53147ac0d738\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400496341074,\n" +
            "    \"modified\" : 1400496341074,\n" +
            "    \"username\" : \"v3y0kf9arx\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"8cf86e4a-df61-11e3-8a70-25cc7e73257e\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400509582116,\n" +
            "    \"modified\" : 1400509582116,\n" +
            "    \"username\" : \"kapzkr9rro\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"a11dca4a-df62-11e3-8551-493bea6a0997\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400510045412,\n" +
            "    \"modified\" : 1400510045412,\n" +
            "    \"username\" : \"vkpvscnkzn\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"860169a4-df64-11e3-aaae-6bc8d50bc307\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400510858921,\n" +
            "    \"modified\" : 1400510858921,\n" +
            "    \"username\" : \"6tkecmjtzn\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"1ed6bffa-df68-11e3-80f0-33f2237fa6e0\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400512403823,\n" +
            "    \"modified\" : 1400512403823,\n" +
            "    \"username\" : \"xc6xrnbzci\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"5472a84a-df68-11e3-b0b9-735c1b1db9a1\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400512493764,\n" +
            "    \"modified\" : 1400512493764,\n" +
            "    \"username\" : \"vrhfk5lxsz\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"79b3db1a-dfbd-11e3-9c5d-3be5e57070a5\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400549063489,\n" +
            "    \"modified\" : 1400549063489,\n" +
            "    \"username\" : \"qmlu5szkbm\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"3a2416ea-dfc2-11e3-a3e8-238b964488ee\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400551104334,\n" +
            "    \"modified\" : 1400551104334,\n" +
            "    \"username\" : \"6pxxbfcnxu\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"65f6cf1a-dfc2-11e3-9dad-2929901f1b97\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400551177857,\n" +
            "    \"modified\" : 1400551177857,\n" +
            "    \"username\" : \"xffslraxae\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"2631911a-dfc9-11e3-803d-23343cadc4ed\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400554077345,\n" +
            "    \"modified\" : 1400554077345,\n" +
            "    \"username\" : \"pfxfc9ggkz\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"4295acaa-dfca-11e3-9bf1-5fd8df7f7659\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400554554474,\n" +
            "    \"modified\" : 1400554554474,\n" +
            "    \"username\" : \"pksaxc6pao\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"8c76072a-dfca-11e3-acc7-7dbd7c3dd494\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400554678418,\n" +
            "    \"modified\" : 1400554678418,\n" +
            "    \"username\" : \"s1yqttgtya\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"93d710ea-dfca-11e3-a6e8-4f903c0b10fb\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400554690798,\n" +
            "    \"modified\" : 1400554690798,\n" +
            "    \"username\" : \"qihp1et8t4\",\n" +
            "    \"activated\" : true\n" +
            "  }, {\n" +
            "    \"uuid\" : \"b1fbbdaa-dfca-11e3-a242-8d6201f83c2b\",\n" +
            "    \"type\" : \"user\",\n" +
            "    \"created\" : 1400554741370,\n" +
            "    \"modified\" : 1400554741370,\n" +
            "    \"username\" : \"0vwy72min6\",\n" +
            "    \"activated\" : true\n" +
            "  } ],\n" +
            "    \"timestamp\" : 1409571908388,\n" +
            "    \"duration\" : 747,\n" +
            "    \"organization\" : \"easemob-demo\",\n" +
            "    \"applicationName\" : \"chatdemoui\",\n" +
            "    \"cursor\" : \"LTU2ODc0MzQzOnNmdTlxdF9LRWVPaVFvMWlBZmc4S3c\",\n" +
            "    \"count\" : 20\n" +
            "   }";


}
