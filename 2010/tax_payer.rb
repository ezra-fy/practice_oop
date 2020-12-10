def TaxPayer
  attr_accessor :name, :yearly_salary, :tax_credit

  def initialize(name, yearly_salary, tax_credit)
    @name = name
    @yearly_salary = yearly_salary.to_f
    @tax_credit = tax_credit.to_f
  end

  def to_string
    @name + " " + @yearly_salary.to_s + " " +@tax_credit.to_s
  end
end
