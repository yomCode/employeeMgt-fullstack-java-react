import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";



const EmployeeDetails = () =>{

    const {id} = useParams();

    const [employee, setEmployee] = useState({

        id: "",
        firstName: "",
        lastName: "",
        email: ""
    })

    useEffect(() => {
        const fetchData = async () => {
            try{
                const response = await EmployeeService.getEmployeeById(id);
                setEmployee(response.data)
            }catch(error){
                console.log(error)
            }
        };
        fetchData();
    }, [id])



    return(
        <div className="w-[100%] flex flex-col justify-center mt-[5rem]">
            <h2 className="text-center">Employee Details</h2>
            <div className="mx-auto p-5 shadow-md rounded-md mt-4">
                <div className="flex items-center gap-2 bg-[#8989d8] px-4"><h6>First Name: </h6> <p className="text-[1.3rem] pt-1">{employee.firstName}</p> </div>
                <div className="flex items-center gap-2 bg-[#8a8aad] px-4"><h6>Last Name: </h6><p className="text-[1.3rem] pt-1">{employee.lastName}</p></div>
                <div className="flex items-center gap-2 bg-[#8989d8]  px-4"><h6>Email Address: </h6><p className="text-[1.3rem] pt-1">{employee.email}</p></div>
            </div>
        </div>
    )
}


export default EmployeeDetails;