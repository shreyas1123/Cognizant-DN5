-- Enable server output to display messages printed via DBMS_OUTPUT.PUT_LINE
SET SERVEROUTPUT ON;

DECLARE
    -- Sample employee variables
    v_emp_id       NUMBER := 101;
    v_emp_name     VARCHAR2(50) := 'John Doe';
    v_salary       NUMBER := 75000;
    v_dept_code    VARCHAR2(10) := 'IT';
    
    -- Variables to hold results
    v_salary_tier  VARCHAR2(20);
    v_dept_name    VARCHAR2(50);
    v_bonus        NUMBER;
    
    -- Loop counter variables
    v_years        NUMBER := 1;
    v_temp_salary  NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('==================================================');
    DBMS_OUTPUT.PUT_LINE('       PL/SQL CONTROL STRUCTURES DEMONSTRATION    ');
    DBMS_OUTPUT.PUT_LINE('==================================================');
    DBMS_OUTPUT.PUT_LINE('Employee ID   : ' || v_emp_id);
    DBMS_OUTPUT.PUT_LINE('Employee Name : ' || v_emp_name);
    DBMS_OUTPUT.PUT_LINE('Base Salary   : $' || TO_CHAR(v_salary, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');

    --------------------------------------------------
    -- 1. IF-ELSE Statement Demonstration
    -- Categorize employee salary into Low, Medium, or High tier
    --------------------------------------------------
    DBMS_OUTPUT.PUT_LINE('1. IF-ELSE STATEMENT: Salary Tier Evaluation');
    IF v_salary > 80000 THEN
        v_salary_tier := 'High Salary';
    ELSIF v_salary >= 50000 THEN
        v_salary_tier := 'Medium Salary';
    ELSE
        v_salary_tier := 'Low Salary';
    END IF;
    DBMS_OUTPUT.PUT_LINE('Salary Tier result: ' || v_salary_tier);
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');

    --------------------------------------------------
    -- 2. CASE Statement Demonstration
    -- Translate department code to full department name
    --------------------------------------------------
    DBMS_OUTPUT.PUT_LINE('2. CASE STATEMENT: Department Code Translation');
    v_dept_name := CASE v_dept_code
        WHEN 'HR'  THEN 'Human Resources'
        WHEN 'IT'  THEN 'Information Technology'
        WHEN 'MKT' THEN 'Marketing'
        WHEN 'FIN' THEN 'Finance'
        ELSE 'Unknown Department'
    END;
    DBMS_OUTPUT.PUT_LINE('Department Code [' || v_dept_code || '] resolves to: ' || v_dept_name);
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');

    --------------------------------------------------
    -- 3. FOR Loop Demonstration
    -- Simulates cumulative monthly bonus calculations over 5 months
    --------------------------------------------------
    DBMS_OUTPUT.PUT_LINE('3. FOR LOOP: Monthly Simulated Bonus Calculation');
    -- The loop runs from month 1 to month 5
    FOR v_month IN 1..5 LOOP
        v_bonus := v_salary * 0.01 * v_month;
        DBMS_OUTPUT.PUT_LINE('Month ' || v_month || ' cumulative bonus: $' || TO_CHAR(v_bonus, '9,999.99'));
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');

    --------------------------------------------------
    -- 4. WHILE Loop Demonstration
    -- Projects 5% compound annual salary increase over 3 years
    --------------------------------------------------
    DBMS_OUTPUT.PUT_LINE('4. WHILE LOOP: Annual Salary Hikes Projection');
    v_temp_salary := v_salary;
    -- Loop continues as long as years count is less than or equal to 3
    WHILE v_years <= 3 LOOP
        v_temp_salary := v_temp_salary * 1.05; -- Apply 5% annual hike
        DBMS_OUTPUT.PUT_LINE('Year ' || v_years || ' projected salary: $' || TO_CHAR(v_temp_salary, '999,999.99'));
        v_years := v_years + 1; -- Increment year counter to avoid infinite loop
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('==================================================');
END;
/
