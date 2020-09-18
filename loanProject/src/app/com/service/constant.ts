const host = "http://localhost:8081/loan";

export const CONSTANT = {
    CREATE_CUSTOMER: host + "/customer/addCustomer",
    CREATE_LOAN: host + "/loanDetails/saveLoan",
    GET_LOAN_BY_USER: host + "/loanDetails/getLoanByUser",
    GET_PAYMENT_SCHEDULE: host + "/loanDetails/getPaymentScheduleByLoan"
}