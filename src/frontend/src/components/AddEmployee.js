import React, {useState } from 'react';
import EmployeeService from '../services/EmployeeService';
import Button from './Button';


const AddEmployee = (props) => {

    const [employee, setEmployee] = useState({

        id: "",
        firstName: "",
        lastName: "",
        email: ""
    })


    const handleChange = (e) => {
        const value = e.target.value;
        setEmployee({ ...employee, [e.target.name]: value});
    }

    const saveEmployee = (e) => {
        e.preventDefault();
        EmployeeService.saveEmployee(employee).then((response)=>{
            console.log(response)
        }).catch((error => {
            console.log(error)
        }))

        setEmployee({
            firstName: "",
            lastName: "",
            email: ""
        });

    }

    const clear = (e) => {
        e.preventDefault();
        setEmployee({
            firstName: "",
            lastName: "",
            email: ""
        })

    }

    return(
        <div>
            <div className='container'>
                <div className='row'>
                    <div className='card col-md-6 offset-md-3 offset-md-3 offset-md-3 mt-4'>
                        <h3 className='text-center'>Add new Employee</h3>
                        <div className='card-body'>
                            <form action="" className='flex flex-col gap-4'>
                                <div className='form-group'>
                                    <label>First Name:</label>
                                    <input type="text" placeholder='First Name' className='form-control'
                                           name='firstName' value={employee.firstName} onChange={(e) => handleChange(e)} />
                                </div>
                                <div>
                                    <label>Last Name:</label>
                                    <input type="text" placeholder='Last Name' className='form-control'
                                           name='lastName' value={employee.lastName} onChange={(e) => handleChange(e)} />
                                </div>
                                <div>
                                    <label>Email Address:</label>
                                    <input type="email" placeholder='Email address' className='form-control'
                                           name='email' value={employee.email} onChange={(e) => handleChange(e)} />
                                </div>
                                <div className='flex gap-3'>
                                    <Button type="submit" classAttr="btn btn-success" title = "Save" click={saveEmployee} />
                                    <Button type="button" classAttr="btn btn-danger" title = "clear" click={clear} />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    )
}

export default AddEmployee;