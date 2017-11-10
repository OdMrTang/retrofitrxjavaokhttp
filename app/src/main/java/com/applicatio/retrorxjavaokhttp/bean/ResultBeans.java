package com.applicatio.retrorxjavaokhttp.bean;

import java.util.List;

/**
 * Created by Tang on 2017/8/22.
 */

public class ResultBeans {

        private String total;
        private String pagenum;
        private String pagesize;
        private String subject;
        private String type;
        private String sort;
        private List<ListBean> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPagenum() {
            return pagenum;
        }

        public void setPagenum(String pagenum) {
            this.pagenum = pagenum;
        }

        public String getPagesize() {
            return pagesize;
        }

        public void setPagesize(String pagesize) {
            this.pagesize = pagesize;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {

            private String question;
            private String option1;
            private String option2;
            private String option3;
            private String option4;
            private String answer;
            private String explain;
            private String pic;
            private String type;

            public String getQuestion() {
                return question;
            }

            public void setQuestion(String question) {
                this.question = question;
            }

            public String getOption1() {
                return option1;
            }

            public void setOption1(String option1) {
                this.option1 = option1;
            }

            public String getOption2() {
                return option2;
            }

            public void setOption2(String option2) {
                this.option2 = option2;
            }

            public String getOption3() {
                return option3;
            }

            public void setOption3(String option3) {
                this.option3 = option3;
            }

            public String getOption4() {
                return option4;
            }

            public void setOption4(String option4) {
                this.option4 = option4;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }

            public String getExplain() {
                return explain;
            }

            public void setExplain(String explain) {
                this.explain = explain;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
}
