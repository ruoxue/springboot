package com.wowotou.payservice.util;

import java.util.List;

public class TT {
    /**
     * alipay_trade_royalty_relation_batchquery_response : {"msg":"Success","current_page_size":20,"total_record_num":15,"code":"10000","total_page_num":1,"result_code":"SUCCESS","current_page_num":1,"receiver_list":[{"memo":"17767072646","type":"userId","account":"2088732495460303"},{"memo":"15996419199","type":"userId","account":"2088722025361897"},{"memo":"18913800958","type":"userId","account":"2088422536026714"},{"memo":"ls151308@163.com","type":"userId","account":"2088732601808928"},{"memo":"15130880511","type":"userId","account":"2088432183492626"},{"memo":"18832839348","type":"userId","account":"2088732240070489"},{"memo":"13851109317","type":"userId","account":"2088312046635653"},{"memo":"zm20200101@163.com","type":"userId","account":"2088612238353661"},{"memo":"13675877633","type":"userId","account":"2088622166785285"},{"memo":"tb2020020201@163.com","type":"userId","account":"2088732538477295"},{"memo":"13675870058","type":"userId","account":"2088522662113530"},{"memo":"18017975073","type":"userId","account":"2088012756148020"},{"memo":"17321052013","type":"userId","account":"2088422293771302"},{"memo":"18013847146","type":"userId","account":"2088732496513495"},{"memo":"shandiangou2020@163.com","type":"userId","account":"2088532846431330"}]}
     * sign : cgBmm/9UMDuWkUViJ8mb6d8mqXJgOQ1MW2TJgXWBtu1z8xsBCmVp4jKSJkMs5xMYIwNaik0IZmiea+35unX05fsTWcqlg/Xj3DOExPfF7JzBr5nOOy2EyUk/LV6nkCbJ0+/eqBfwQzf3XKm0gHXNF49suEs5GQVgfHIsinXEOnZ10laK2ouCEUSlvfCSSqeUc2CsISl/C2aQkKxoOrGXhxjGMN13nF9RLlPf+4QQd+KecJwmV37EzqHIpILkiLz4D1Sca/ggCvWWroH4LGYnG6F9cW1UoGmC2+SxXQt2oNS1OUlndE7Xo29sY7JmL4YLwyjtjV2qEB3kIGnox9iRNg==
     */
    private Alipay_trade_royalty_relation_batchquery_responseEntity alipay_trade_royalty_relation_batchquery_response;
    private String sign;

    public void setAlipay_trade_royalty_relation_batchquery_response(Alipay_trade_royalty_relation_batchquery_responseEntity alipay_trade_royalty_relation_batchquery_response) {
        this.alipay_trade_royalty_relation_batchquery_response = alipay_trade_royalty_relation_batchquery_response;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Alipay_trade_royalty_relation_batchquery_responseEntity getAlipay_trade_royalty_relation_batchquery_response() {
        return alipay_trade_royalty_relation_batchquery_response;
    }

    public String getSign() {
        return sign;
    }

    public class Alipay_trade_royalty_relation_batchquery_responseEntity {
        /**
         * msg : Success
         * current_page_size : 20
         * total_record_num : 15
         * code : 10000
         * total_page_num : 1
         * result_code : SUCCESS
         * current_page_num : 1
         * receiver_list : [{"memo":"17767072646","type":"userId","account":"2088732495460303"},{"memo":"15996419199","type":"userId","account":"2088722025361897"},{"memo":"18913800958","type":"userId","account":"2088422536026714"},{"memo":"ls151308@163.com","type":"userId","account":"2088732601808928"},{"memo":"15130880511","type":"userId","account":"2088432183492626"},{"memo":"18832839348","type":"userId","account":"2088732240070489"},{"memo":"13851109317","type":"userId","account":"2088312046635653"},{"memo":"zm20200101@163.com","type":"userId","account":"2088612238353661"},{"memo":"13675877633","type":"userId","account":"2088622166785285"},{"memo":"tb2020020201@163.com","type":"userId","account":"2088732538477295"},{"memo":"13675870058","type":"userId","account":"2088522662113530"},{"memo":"18017975073","type":"userId","account":"2088012756148020"},{"memo":"17321052013","type":"userId","account":"2088422293771302"},{"memo":"18013847146","type":"userId","account":"2088732496513495"},{"memo":"shandiangou2020@163.com","type":"userId","account":"2088532846431330"}]
         */
        private String msg;
        private int current_page_size;
        private int total_record_num;
        private String code;
        private int total_page_num;
        private String result_code;
        private int current_page_num;
        private List<Receiver_listEntity> receiver_list;

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setCurrent_page_size(int current_page_size) {
            this.current_page_size = current_page_size;
        }

        public void setTotal_record_num(int total_record_num) {
            this.total_record_num = total_record_num;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setTotal_page_num(int total_page_num) {
            this.total_page_num = total_page_num;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public void setCurrent_page_num(int current_page_num) {
            this.current_page_num = current_page_num;
        }

        public void setReceiver_list(List<Receiver_listEntity> receiver_list) {
            this.receiver_list = receiver_list;
        }

        public String getMsg() {
            return msg;
        }

        public int getCurrent_page_size() {
            return current_page_size;
        }

        public int getTotal_record_num() {
            return total_record_num;
        }

        public String getCode() {
            return code;
        }

        public int getTotal_page_num() {
            return total_page_num;
        }

        public String getResult_code() {
            return result_code;
        }

        public int getCurrent_page_num() {
            return current_page_num;
        }

        public List<Receiver_listEntity> getReceiver_list() {
            return receiver_list;
        }

        public class Receiver_listEntity {
            /**
             * memo : 17767072646
             * type : userId
             * account : 2088732495460303
             */
            private String memo;
            private String type;
            private String account;

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getMemo() {
                return memo;
            }

            public String getType() {
                return type;
            }

            public String getAccount() {
                return account;
            }
        }
    }
}
