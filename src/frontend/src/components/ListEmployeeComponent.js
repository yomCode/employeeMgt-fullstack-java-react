import React, {useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';
import Button from './Button';


const ListEmployee = () => {

    const navigate = useNavigate();


    const [loading, setLoading] = useState(true);
    const [employees, setEmployees] = useState(null);

    useEffect(() => {
        const fetchData = async () =>{
            setLoading(true);
            try{
                const response = EmployeeService.getEmployees();
                setEmployees((await response).data)
            }catch(error){
                console.log(error);
            }
            setLoading(false);
        };
        fetchData();
    }, []);


    const updateEmployee = (e, id) => {
        e.preventDefault();
        navigate(`/updateEmployee/${id}`);
    }

    const getEmployee = (e, id) =>{
        e.preventDefault();
        navigate(`/getEmployee/${id}`);
    }


    const deleteEmployee = (e, id) => {
        e.preventDefault();
        EmployeeService.deleteEmployee(id).then((response) => {
            if(employees){
                setEmployees((prevElement) =>{
                    return prevElement.filter((employee) => employee.id !== id);
                })
            }
        })
    }

    return(
        <div className='flex flex-col gap-4'>
            <h2 className='text-center' >Employee List</h2>
            <div>
                <button className='btn btn-primary' onClick={() => navigate("/addEmployee")}>Add new Employee</button>
            </div>
            <div className='row'>
                <table className='table table-striped table-bordered'>
                    <thead>
                    <tr>
                        <th className='text-center'>S/N</th>
                        <th className='text-center'>Employee First Name</th>
                        <th className='text-center'>Employee Last Name</th>
                        <th className='text-center'>Employee Email</th>
                        <th className='text-center'>Action</th>
                    </tr>
                    </thead>
                    {
                        !loading && (
                            <tbody>
                            {
                                employees.map((employee) => (

                                    <tr key = {employee.id}>
                                        <td> {employees.indexOf(employee) + 1} </td>
                                        <td>{employee.firstName}</td>
                                        <td>{employee.lastName}</td>
                                        <td>{employee.email}</td>
                                        <td>
                                            <div className='col d-flex justify-content-around'>
                                                <Button type="button"  title = "Delete" classAttr='btn btn-danger' click={(e, id) => deleteEmployee(e, employee.id)} />
                                                <Button type="button" title = "Edit" classAttr='btn btn-primary' click={(e, id) => updateEmployee(e, employee.id)} />
                                                <Button type="button" title = "View" classAttr='btn btn-info' click={(e, id) => getEmployee(e, employee.id)} />
                                            </div>

                                        </td>
                                    </tr>

                                ))
                            }


                            </tbody>
                        )}
                </table>
            </div>
        </div>
    )

}

export default ListEmployee;