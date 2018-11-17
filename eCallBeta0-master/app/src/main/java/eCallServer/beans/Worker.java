package eCallServer.beans;

import java.io.Serializable;

public class Worker implements Serializable
{
        private String count;
        private String name;
        private String age;
        private String province;
        private String city;
        private String tel;
        private String pro;

        public Worker(String name, String age, String province, String city, String tel, String pro)
        {
                this.name = name;
                this.age = age;
                this.province = province;
                this.city = city;
                this.tel = tel;
                this.pro = pro;
        }

        public void setName(String name)
        {
                this.name = name;
        }
        public String getName()
        {
                return name;
        }

        public void setAge(String age)
        {
                this.age = age;
        }
        public String getAge()
        {
                return age;
        }

        public void setProvince(String province)
        {
                this.province = province;
        }
        public String getProvince()
        {
                return province;
        }

        public String getCity() {
                return city;
        }
        public void setCity(String city) {
                this.city = city;
        }

        public String getTel() {
                return tel;
        }
        public void setTel(String tel) {
                this.tel = tel;
        }

        public String getPro() {
                return pro;
        }
        public void setPro(String pro) {
                this.pro = pro;
        }

        public String toString()
        {
                return "Worker:\nname= "+ name + "\nage=" + age + "\ntel=" + tel;
        }

        public String getCount() {
                return count;
        }

        public void setCount(String count) {
                this.count = count;
        }
}
