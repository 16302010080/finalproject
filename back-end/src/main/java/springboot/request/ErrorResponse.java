package springboot.request;

/**
 * Created by 董达芬 on 2019/5/27.
 */
public class ErrorResponse {
        String string;
        public ErrorResponse(String string) {
            this.string = string;
        }
        public void setString(String string){
            this.string = string;
        }
        public String getString(){
            return string;
        }
}
