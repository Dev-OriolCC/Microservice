package com.oriol.app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Pagination<T> {
    public static final String BASE_URL = "http://localhost:8080";
    private String previousPage;
    private String nextPage;
    private List<T> body;

    public Pagination(String previousPage, String nextPage, List<T> body) {
        this.previousPage = previousPage;
        this.nextPage = nextPage;
        this.body = body;
    }

    public static class PaginationPageBuilder<T> {
        private List<T> body;
        private int pageNumber;
        private int totalPages;
        private String resource;
        public PaginationPageBuilder(String resource) {
            this.resource = resource;
        }

        public PaginationPageBuilder body(List<T> body) {
            this.body = body;
            return this;
        }

        public PaginationPageBuilder pageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public PaginationPageBuilder totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Pagination<T> build() {
            return new Pagination<T>(
                    getPreviousPage(),
                    getNextPage(),
                    this.body);
        }

        private String getNextPage() {
            if(pageNumber < totalPages - 1) {
                return  buildUrl() + (pageNumber + 1) ;
            }
            return null;
        }
        private String getPreviousPage() {
            if(pageNumber > 0 && pageNumber < totalPages - 1){
                return buildUrl() + (pageNumber -1);
            }
            return null;
        }

        private String buildUrl (){
            return BASE_URL + this.resource +  "?page=";
        }
    }


}
