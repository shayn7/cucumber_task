package dev.naamad.enums;

import dev.naamad.pages.*;
import dev.naamad.steps.BaseSteps;

public enum Page {

    HOME_PAGE(){
        @Override
        public BasePage getPage(BaseSteps baseSteps) {
            return new HomePage(baseSteps);
        }
    },

    CART_PAGE(){
        @Override
        public BasePage getPage(BaseSteps baseSteps) {
            return new CartPage(baseSteps);
        }
    },
    SIGNUP_PAGE(){
        @Override
        public BasePage getPage(BaseSteps baseSteps) {
            return new SignupPage(baseSteps);
        }
    },

    PRODUCT_PAGE(){
        @Override
        public BasePage getPage(BaseSteps baseSteps) {
            return new ProductPage(baseSteps);
        }
    },

    LOGIN_PAGE(){
        @Override
        public BasePage getPage(BaseSteps baseSteps) {
            return new LoginPage(baseSteps);
        }
    };

    public abstract BasePage getPage(BaseSteps baseSteps);

}
