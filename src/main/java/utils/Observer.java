package utils;

public interface Observer {
        /**
         * Un observateur doit posséder une méthode [update] déclenchant la mise à
         * jour.
         */
        public void update();
        /**
         * La version officielle de Java possède des paramètres précisant le
         * changement qui a eu lieu.
         */
}
