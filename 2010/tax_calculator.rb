def TaxCalculator
  def initialize(yearly_salary, tax_credit)
    @yearly_salary = yearly_salary.to_f
    @tax_credit = tax_credit.to_f
    @tax_threshold = 34000
    @base_rate = 0.2
    @higher_rate = 0.41
  end

  def calculate_tax_due
    tax_due = 0
    taxable_salary = @yearly_salary
    if @yearly_salary > 34000
      tax_due = (@yearly_salary - 34000) * @higher_rate
      taxable_salary -= @yearly_salary
    end
    tax_due += (taxable_salary * @base_rate) - @tax_credit
  end
end
