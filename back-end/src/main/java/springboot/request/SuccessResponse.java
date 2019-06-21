package springboot.request;

/**
 * Created by 董达芬 on 2019/5/27.
 */
public class SuccessResponse {
        String string;
        public SuccessResponse(String string) {
            this.string = string;
        }
        public void setString(String string){
            this.string = string;
        }
        public String getString(){
            return string;
        }

}
