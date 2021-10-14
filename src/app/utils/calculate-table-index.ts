import { Injectable } from "@angular/core";
import { PagingArgs } from "../component/common/pagination/pagination.component";

@Injectable({
  providedIn: 'root'
})
export class CalculateTableIndex {
    calculateIndex(
        pagingArgs: PagingArgs,
        totalPages,
        totalElements,
        index
    ) {
        let number =
            pagingArgs.sortBy == "id"
                ? pagingArgs.sortDirection == "desc"
                    ? (pagingArgs.pageNumber - 1) * pagingArgs.pageSize + index +  1
                    : pagingArgs.pageNumber * pagingArgs.pageSize < totalElements && pagingArgs.pageSize != totalElements
                    ? (totalPages - pagingArgs.pageNumber) * pagingArgs.pageSize - index + 2
                    : (totalPages - pagingArgs.pageNumber) * pagingArgs.pageSize - index + totalElements
                : pagingArgs.sortDirection == "asc"
                    ? (pagingArgs.pageNumber - 1) * pagingArgs.pageSize + index + 1
                    : pagingArgs.pageNumber * pagingArgs.pageSize < totalElements && pagingArgs.pageSize != totalElements
                    ? (totalPages - pagingArgs.pageNumber) * pagingArgs.pageSize - index +  2
                    : (totalPages - pagingArgs.pageNumber) * pagingArgs.pageSize - index +  totalElements;
        return number;
    }
}
